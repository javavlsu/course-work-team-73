package BoardMeet.Backend.Service;

import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.Model.User;
import BoardMeet.Backend.dto.UserRegisterDTO;

import java.util.List;

public interface UserService {
    User register(UserRegisterDTO user);
    List<User> getAll();
    User findByUsername(String username);
    User findById (Long Id);
    boolean  delete(Long Id);
    List<Meet> getCreatedMeet(Long Id);
    List<Meet> getJoinedMeet(Long Id);
    List<BoardGame> getCreatedBoardGame(Long Id);

}
