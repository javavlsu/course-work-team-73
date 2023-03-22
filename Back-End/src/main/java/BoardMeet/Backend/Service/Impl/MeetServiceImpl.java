package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotFoundMeetException;
import BoardMeet.Backend.Exception.NotFoundUserException;
import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.Model.MeetState;
import BoardMeet.Backend.Model.User;
import BoardMeet.Backend.Repository.MeetRepository;
import BoardMeet.Backend.Repository.UserRepository;
import BoardMeet.Backend.Service.ControllAccessService;
import BoardMeet.Backend.Service.MeetService;
import BoardMeet.Backend.dto.MeetChangeDTO;
import BoardMeet.Backend.dto.MeetCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MeetServiceImpl implements MeetService {
    @Autowired
    private  final MeetRepository meetRepository;
    @Autowired
    private  final UserRepository userRepository;
    @Autowired
    private  final ControllAccessService controllAccessService;
    public MeetServiceImpl(@Lazy MeetRepository meetRepository, @Lazy UserRepository userRepository, ControllAccessService controllAccessService) {
        this.meetRepository = meetRepository;
        this.userRepository = userRepository;
        this.controllAccessService = controllAccessService;
    }

    @Override
    public List<Meet> getAll() {
        return meetRepository.findAll();
    }

    @Override
    public Meet get(Long id) throws  NotFoundMeetException{
        return meetRepository.findById(id).orElseThrow(()->new NotFoundMeetException("Not Found meet this id: " + id));
    }

    @Override
    public Meet create(MeetCreateDTO meet)throws NoAccessException {
        controllAccessService.tryAccess(meet.getAuthorId());
        return meetRepository.save(new Meet(meet));

    }

    @Override
    public Meet change(MeetChangeDTO meet) throws NotFoundMeetException, NoAccessException  {
        Meet meetLast = meetRepository.findById(meet.getId()).orElseThrow(()->new NotFoundMeetException("Not Found changing meet this id: " + meet.getId()));
        controllAccessService.tryAccess(meetLast.getAuthorId());
        meetLast.change(meet);
        meetRepository.save(meetLast);
        return meetLast;
    }

    @Override
    public void delete(Long id)  throws  NotFoundMeetException,NoAccessException{
        Meet meet = meetRepository.findById(id).orElseThrow(()->new NotFoundMeetException("Not Found deleting meet this id: " + id ));
        controllAccessService.tryAccess(meet.getAuthorId());
        meetRepository.delete(meet);
    }

    @Override
    public void exit(Long meetId, Long userId) throws  NotFoundMeetException, NoAccessException {
        controllAccessService.tryAccess(userId);
        Meet meet = meetRepository.findById(meetId).orElseThrow(()->new NotFoundMeetException("Not Found exited meet this id: " + meetId));
        meet.getPlayers().removeIf(user -> (user.getId() == userId) );
        meetRepository.save(meet);
    }
    @Override
    public void join(Long meetId, Long userId) throws NotFoundMeetException, NotFoundUserException, NoAccessException {
        controllAccessService.tryAccess(userId);
        Meet meet = meetRepository.findById(meetId).orElseThrow(()->new NotFoundMeetException("Not Found joining meet this id: " + meetId));
        User user =  userRepository.findById(userId).orElseThrow(()->new NotFoundMeetException("Not Found joining user this id: " + userId));
        meet.getPlayers().add(user);
        meetRepository.save(meet);
    }

    @Override
    public void lock(Long id) throws  NotFoundMeetException, NoAccessException {
        Meet meetLocking = meetRepository.findById(id).orElseThrow(()->new NotFoundMeetException("Not Found locking meet this id: " + id));
        controllAccessService.tryAccess(meetLocking.getAuthorId());
        if(meetLocking.getState() == MeetState.STARTOPEN) {
            meetLocking.setState(MeetState.STARTLOCK);
            meetRepository.save(meetLocking);
        }
    }

    @Override
    public void open(Long id) throws  NotFoundMeetException, NoAccessException {
        Meet meetLocking = meetRepository.findById(id).orElseThrow(()-> new NotFoundMeetException("Not Found locking meet this id: " + id));
        controllAccessService.tryAccess(meetLocking.getAuthorId());
        if(meetLocking.getState() == MeetState.STARTLOCK){
            meetLocking.setState(MeetState.STARTOPEN);
            meetRepository.save(meetLocking);
        }
    }
    @Override
    public List<Meet> search(String searchVal) {
        return meetRepository.findByNameContains(searchVal);
    }
    @Scheduled(fixedDelay = 10000)
    public void refreshStateMeet(){
        List<Meet> meets = getAll();
        for(Meet meet : meets){
            meet.refreshState();
        }
        meetRepository.saveAll(meets);
    }
}