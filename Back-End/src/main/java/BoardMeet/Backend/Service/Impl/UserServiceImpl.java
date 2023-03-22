package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotAccessExtensionException;
import BoardMeet.Backend.Exception.NotFoundUserException;
import BoardMeet.Backend.Exception.UserExistException;
import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.Model.User;
import BoardMeet.Backend.Repository.UserRepository;
import BoardMeet.Backend.Service.ControllAccessService;
import BoardMeet.Backend.Service.FileService;
import BoardMeet.Backend.Service.UserService;
import BoardMeet.Backend.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.NotActiveException;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;
    private  final ControllAccessService controllAccessService;
    private  final FileService fileService;
    private  final  BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(@Lazy UserRepository userRepository, ControllAccessService controllAccessService, FileService fileService, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.controllAccessService = controllAccessService;
        this.fileService = fileService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User register(UserRegisterDTO userDTO) throws UserExistException{
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        if(userRepository.existsByUsername(userDTO.getUsername())){
            throw  new UserExistException(userDTO.getUsername());
        }
        User user = new User(userDTO);
        User registeredUser = userRepository.save(user);
        return registeredUser;
    }

    @Override
    public String uploadAvatar(MultipartFile avatar, Long userId ) throws IOException, NotFoundUserException,NotAccessExtensionException, NoAccessException {
        User user = userRepository.findById(userId).orElseThrow(()->new NotFoundUserException("User by id : " + userId + " Not Found"));

        controllAccessService.tryAccess(userId);
        user.setAvatarUrl(fileService.uploadAvatar(avatar));

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
