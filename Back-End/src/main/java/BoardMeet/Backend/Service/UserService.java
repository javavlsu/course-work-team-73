package BoardMeet.Backend.Service;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotAccessExtensionException;
import BoardMeet.Backend.Exception.NotFoundUserException;
import BoardMeet.Backend.Exception.UserExistException;
import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.Model.User;
import BoardMeet.Backend.DTO.UserRegisterDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface UserService {
    User register(UserRegisterDTO user) throws UserExistException;
    String uploadAvatar(MultipartFile avatar,Long userId) throws IOException, NotFoundUserException, NotAccessExtensionException, NoAccessException;
    List<User> getAll();
    User findByUsername(String username);
    User get (Long Id) throws NotFoundUserException;
    void delete(Long Id) throws NotFoundUserException;
    Set<Meet> getCreatedMeet(Long Id) throws NotFoundUserException;
    Set<Meet> getJoinedMeet(Long Id) throws NotFoundUserException;
    Set<BoardGame> getCreatedBoardGame(Long Id) throws NotFoundUserException;
}
