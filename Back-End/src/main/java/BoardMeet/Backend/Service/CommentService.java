package BoardMeet.Backend.Service;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotFoundCommentException;
import BoardMeet.Backend.Model.Comment;
import BoardMeet.Backend.DTO.CommentCreateDTO;

public interface CommentService {
    Comment create(CommentCreateDTO comment) throws NoAccessException;
    void delete(Long Id) throws NotFoundCommentException, NoAccessException;
    Comment get(Long Id) throws  NotFoundCommentException;
}
