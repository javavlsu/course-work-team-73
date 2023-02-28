package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.Model.User;
import BoardMeet.Backend.Repository.UserRepository;
import BoardMeet.Backend.Service.UserService;
import BoardMeet.Backend.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;
    private  final  BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(@Lazy UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User register(UserRegisterDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = new User(userDTO);
        User registeredUser = userRepository.save(user);
        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        return result;
    }

    @Override
    public User findById(Long Id) {
        User result = userRepository.findById(Id).orElse(null);
        if(result == null){
            return  null;
        }
        return result;
    }

    @Override
    public boolean delete(Long Id) {
        userRepository.deleteById(Id);
        return true;
    }

    @Override
    public List<Meet> getCreatedMeet(Long Id) {
        return null;
    }

    @Override
    public List<Meet> getJoinedMeet(Long Id) {
        return null;
    }

    @Override
    public List<BoardGame> getCreatedBoardGame(Long Id) {
        return null;
    }

}
