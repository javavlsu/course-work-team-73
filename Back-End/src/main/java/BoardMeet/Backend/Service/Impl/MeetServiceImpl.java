package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Exception.NotFoundMeetException;
import BoardMeet.Backend.Exception.NotFoundUserException;
import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.Model.MeetState;
import BoardMeet.Backend.Model.User;
import BoardMeet.Backend.Repository.MeetRepository;
import BoardMeet.Backend.Repository.UserRepository;
import BoardMeet.Backend.Service.MeetService;
import BoardMeet.Backend.dto.MeetChangeDTO;
import BoardMeet.Backend.dto.MeetCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;
@Service
public class MeetServiceImpl implements MeetService {
    @Autowired
    private  final MeetRepository meetRepository;
    @Autowired
    private  final UserRepository userRepository;

    public MeetServiceImpl(@Lazy MeetRepository meetRepository, @Lazy UserRepository userRepository) {
        this.meetRepository = meetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Meet> getAll() {
        return meetRepository.findAll();
    }

    @Override
    public Meet get(Long Id) {
        return meetRepository.findById(Id).orElse(null);
    }

    @Override
    public Meet create(MeetCreateDTO meet) {
        return meetRepository.save(new Meet(meet));
    }

    @Override
    public Meet change(MeetChangeDTO meet) throws NotFoundMeetException  {
        Meet meetLast = meetRepository.findById(meet.getId()).orElse(null);
        if(meetLast == null)
            throw  new NotFoundMeetException("Not Found changing meet this id: " + meet.getId());
        meetLast.change(meet);
        meetRepository.save(meetLast);
        return meetLast;
    }

    @Override
    public void delete(Long Id)  throws  NotFoundMeetException{
        Meet meet = meetRepository.findById(Id).orElse(null);
        if (meet == null){
            throw  new NotFoundMeetException("Not Found deleting meet this id: " + Id );
        }
        meetRepository.delete(meet);
    }

    @Override
    public void exit(Long meetId, Long userId) throws  NotFoundMeetException {
        Meet meet = meetRepository.findById(meetId).orElse(null);
        if (meet == null)
            throw  new NotFoundMeetException("Not Found exited meet this id: " + meetId);
        meet.getPlayers().removeIf(user -> (user.getId() == userId) );
        meetRepository.save(meet);
    }
    @Override
    public void join(Long meetId, Long userId) throws NotFoundMeetException, NotFoundUserException {
        Meet meet = meetRepository.findById(meetId).orElse(null);
        if (meet == null)
            throw  new NotFoundMeetException("Not Found joining meet this id: " + meetId);

        User user =  userRepository.findById(userId).orElse(null);
        if (user == null)
            throw  new NotFoundMeetException("Not Found joining user this id: " + userId);
        meet.getPlayers().add(user);
        meetRepository.save(meet);
    }

    @Override
    public void lock(Long Id) throws  NotFoundMeetException {
        Meet meetLocking = meetRepository.findById(Id).orElse(null);
        if (meetLocking == null)
            throw new NotFoundMeetException("Not Found locking meet this id: " + Id);
        if(meetLocking.getState() == MeetState.STARTOPEN) {
            meetLocking.setState(MeetState.STARTLOCK);
            meetRepository.save(meetLocking);
        }
    }

    @Override
    public void open(Long Id) throws  NotFoundMeetException {
        Meet meetLocking = meetRepository.findById(Id).orElse(null);
        if (meetLocking == null)
            throw new NotFoundMeetException("Not Found locking meet this id: " + Id);

        if(meetLocking.getState() == MeetState.STARTLOCK){
            meetLocking.setState(MeetState.STARTOPEN);
            meetRepository.save(meetLocking);
        }
    }
    @Override
    public List<Meet> search(String searchVal) {
        return meetRepository.findByNameContains(searchVal);
    }
}