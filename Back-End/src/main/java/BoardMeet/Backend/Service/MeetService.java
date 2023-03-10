package BoardMeet.Backend.Service;

import BoardMeet.Backend.Exception.NotFoundMeetException;
import BoardMeet.Backend.Exception.NotFoundUserException;
import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.dto.MeetChangeDTO;
import BoardMeet.Backend.dto.MeetCreateDTO;

import java.util.List;

public interface MeetService {
    List<Meet> getAll();
    Meet get(Long Id);
    Meet create(MeetCreateDTO meet);
    Meet change(MeetChangeDTO meet) throws NotFoundMeetException;
    void delete(Long Id)  throws  NotFoundMeetException;
    void exit(Long meetId, Long userId) throws NotFoundMeetException;
    void join(Long meetId, Long userId) throws NotFoundMeetException, NotFoundUserException;
    void lock(Long Id) throws NotFoundMeetException;
    void open(Long Id) throws NotFoundMeetException;
    List<Meet> search(String searchVal);


}
