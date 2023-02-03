package BoardMeet.Backend.Service;

import BoardMeet.Backend.Model.User;
import BoardMeet.Backend.dto.UserRegisterDTO;

import java.util.List;

public interface UserService {
    User register(UserRegisterDTO user);
    List<User> getAll();
    User findByUsername(String username);
    User findById (Long Id);
    void  delete(Long id);
}
