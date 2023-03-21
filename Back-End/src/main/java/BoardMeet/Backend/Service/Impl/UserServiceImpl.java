package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Exception.NotAccessExtensionException;
import BoardMeet.Backend.Exception.NotFoundUserException;
import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.Model.User;
import BoardMeet.Backend.Repository.UserRepository;
import BoardMeet.Backend.Service.FileService;
import BoardMeet.Backend.Service.UserService;
import BoardMeet.Backend.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;

    private  final FileService fileService;
    private  final  BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(@Lazy UserRepository userRepository, FileService fileService, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.fileService = fileService;
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
    public String uploadAvatar(MultipartFile avatar, Long userId ) throws IOException, NotFoundUserException,NotAccessExtensionException {
        User user = userRepository.findById(userId).orElseThrow(()->new NotFoundUserException("User by id : " + userId + " Not Found"));
        try {
            user.setAvatarUrl(fileService.uploadAvatar(avatar));
        } catch (NotAccessExtensionException e) {
            throw e;
        }
        userRepository.save(user);
        return user.getAvatarUrl();
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
    public User get(Long id) throws NotFoundUserException{
        User user = userRepository.findById(id).orElseThrow(()->new NotFoundUserException("User by id : " + id + " Not Found"));
        return user;
    }

    @Override
    public void delete(Long id) throws NotFoundUserException{
        User user = userRepository.findById(id).orElseThrow(()->new NotFoundUserException("User by id : " + id + " Not Found"));
        userRepository.delete(user);
    }

    @Override
    public Set<Meet> getCreatedMeet(Long id) throws NotFoundUserException{
        User user = userRepository.findById(id).orElseThrow(()->new NotFoundUserException("User by id : " + id + " Not Found"));
        return user.getCreatedMeets();
    }

    @Override
    public Set<Meet> getJoinedMeet(Long id) throws NotFoundUserException{
        User user = userRepository.findById(id).orElseThrow(()->new NotFoundUserException("User by id : " + id + " Not Found"));
        return user.getJoinedMeets();
    }
    @Override
    public Set<BoardGame> getCreatedBoardGame(Long id) throws NotFoundUserException{
        User user = userRepository.findById(id).orElseThrow(()->new NotFoundUserException("User by id : " + id + " Not Found"));
        return user.getCreateBoardGames();
    }
}
