package BoardMeet.Backend.controller;

import BoardMeet.Backend.Exception.NotFoundUserException;
import BoardMeet.Backend.Model.User;
import BoardMeet.Backend.Service.UserService;
import BoardMeet.Backend.dto.UserRegisterDTO;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/users/")
public class UsersController {

    private final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody UserRegisterDTO userDTO){
        return new ResponseEntity<>(userService.register(userDTO), HttpStatus.OK);
    }
    @PostMapping("{Id}/uploadAvatar")
    public ResponseEntity<?> upload(@RequestParam("image")MultipartFile avatar,@PathVariable Long Id){
        try {
            return  new ResponseEntity<>(userService.uploadAvatar(avatar,Id),HttpStatus.OK);
        }catch (IOException e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }catch (NotFoundUserException e ){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }
    @GetMapping("{Id}")
    public ResponseEntity<?> get(@PathVariable Long Id){
        try {
            return new ResponseEntity<>(userService.get(Id),HttpStatus.OK);
        }catch (NotFoundUserException e ){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{Id}")
    public  ResponseEntity<?> delete(@PathVariable Long Id){
        try {
            userService.delete(Id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundUserException e ){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("{Id}/createdMeet")
    public  ResponseEntity<?> getCreatedMeet(@PathVariable Long Id){
        try {
            return new ResponseEntity<>(userService.getCreatedMeet(Id),HttpStatus.OK);
        }catch (NotFoundUserException e ){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("{Id}/joinedMeet")
    public  ResponseEntity<?> getJoinedMeet(@PathVariable Long Id){
        try {
            return new ResponseEntity<>(userService.getJoinedMeet(Id),HttpStatus.OK);
        }catch (NotFoundUserException e ){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("{Id}/createdBoardGame")
    public  ResponseEntity<?> getCreatedBoardGame(@PathVariable Long Id){
        try {
            return new ResponseEntity<>(userService.getCreatedBoardGame(Id),HttpStatus.OK);
        }catch (NotFoundUserException e ){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
