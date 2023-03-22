package BoardMeet.Backend.controller;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotAccessExtensionException;
import BoardMeet.Backend.Exception.NotFoundUserException;
import BoardMeet.Backend.Exception.UserExistException;
import BoardMeet.Backend.Model.User;
import BoardMeet.Backend.Service.UserService;
import BoardMeet.Backend.dto.UserRegisterDTO;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
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
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterDTO userDTO){
        try {
            return new ResponseEntity(userService.register(userDTO), HttpStatus.OK);
        }catch (UserExistException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("{id}/uploadAvatar")
    public ResponseEntity<?> upload(@RequestParam("image")MultipartFile avatar,@PathVariable Long id){
        try {
            return  new ResponseEntity<>(userService.uploadAvatar(avatar,id),HttpStatus.OK);
        }catch (IOException e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }catch (NotFoundUserException e ){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        } catch (NotAccessExtensionException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        } catch (NoAccessException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        try {
            return new ResponseEntity<>(userService.get(id),HttpStatus.OK);
        }catch (NotFoundUserException e ){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @RolesAllowed("ROLE_ADMIN")
    @DeleteMapping("{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id){
        try {
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundUserException e ){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("{id}/createdMeet")
    public  ResponseEntity<?> getCreatedMeet(@PathVariable Long id){
        try {
            return new ResponseEntity<>(userService.getCreatedMeet(id),HttpStatus.OK);
        }catch (NotFoundUserException e ){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("{id}/joinedMeet")
    public  ResponseEntity<?> getJoinedMeet(@PathVariable Long id){
        try {
            return new ResponseEntity<>(userService.getJoinedMeet(id),HttpStatus.OK);
        }catch (NotFoundUserException e ){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("{id}/createdBoardGame")
    public  ResponseEntity<?> getCreatedBoardGame(@PathVariable Long id){
        try {
            return new ResponseEntity<>(userService.getCreatedBoardGame(id),HttpStatus.OK);
        }catch (NotFoundUserException e ){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
