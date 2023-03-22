package BoardMeet.Backend.Service;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotFoundMeetException;
import BoardMeet.Backend.Exception.NotFoundUserException;
import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.dto.MeetChangeDTO;
import BoardMeet.Backend.dto.MeetCreateDTO;

import java.util.List;

public interface MeetService {
    List<Meet> getAll();
    Meet get(Long Id) throws  NotFoundMeetException;
    Meet create(MeetCreateDTO meet)throws NoAccessException;
    Meet change(MeetChangeDTO meet) throws NotFoundMeetException, NoAccessException;
    void delete(Long Id)  throws  NotFoundMeetException, NoAccessException;
    void exit(Long meetId, Long userId) throws NotFoundMeetException, NoAccessException;
    void join(Long meetId, Long userId) throws NotFoundMeetException, NotFoundUserException, NoAccessException;
    void lock(Long Id) throws NotFoundMeetException, NoAccessException;
    void open(Long Id) throws NotFoundMeetException, NoAccessException;
    List<Meet> search(String searchVal);


}
