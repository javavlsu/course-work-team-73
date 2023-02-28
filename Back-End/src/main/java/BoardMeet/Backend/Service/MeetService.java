package BoardMeet.Backend.Service;

import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.dto.MeetChangeDTO;
import BoardMeet.Backend.dto.MeetCreateDTO;

import java.util.List;

public interface MeetService {
    List<Meet> getAll();
    Meet get(Long Id);
    Meet create(MeetCreateDTO meet);
    Meet change(MeetChangeDTO meet);
    boolean delete(Long Id);
    boolean exit(Long meetId,Long userId);
    boolean lock(Long Id);
    boolean open(Long Id);
    List<Meet> search(String searchVal);


}
