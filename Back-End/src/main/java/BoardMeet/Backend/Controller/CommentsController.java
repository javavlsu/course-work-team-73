package BoardMeet.Backend.Controller;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotFoundCommentException;
import BoardMeet.Backend.Service.CommentService;
import BoardMeet.Backend.DTO.CommentCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/comment/")
public class CommentsController {

    @Autowired
    private  final CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    @Secured({"ROLE_PLAYER"})
    public ResponseEntity<?> post(@Valid @RequestBody CommentCreateDTO comment){
        try {
            return  new ResponseEntity(commentService.create(comment), HttpStatus.OK);
        }catch (NoAccessException e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }
    @GetMapping("{id}")
    public  ResponseEntity<?> get(@PathVariable Long id){
        try {
            return  new ResponseEntity( commentService.get(id),HttpStatus.OK);
        }catch (NotFoundCommentException e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping("{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id)  {
        try {
            commentService.delete(id);
            return  new ResponseEntity(HttpStatus.OK);
        }catch (NotFoundCommentException e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch (NoAccessException e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
