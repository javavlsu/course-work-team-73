package BoardMeet.Backend.controller;

import BoardMeet.Backend.Exception.NotFoundCommentException;
import BoardMeet.Backend.Model.Comment;
import BoardMeet.Backend.Service.CommentService;
import BoardMeet.Backend.dto.CommentCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/comment/")
public class CommentsController {

    @Autowired
    private  final CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody CommentCreateDTO comment){
        return  new ResponseEntity(commentService.create(comment), HttpStatus.OK);

    }
    @GetMapping("{id}")
    public  ResponseEntity<?> get(@PathVariable Long id){
        try {
            return  new ResponseEntity( commentService.get(id),HttpStatus.OK);
        }catch (NotFoundCommentException e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id){
        try {
            commentService.delete(id);
            return  new ResponseEntity(HttpStatus.OK);
        }catch (NotFoundCommentException e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
