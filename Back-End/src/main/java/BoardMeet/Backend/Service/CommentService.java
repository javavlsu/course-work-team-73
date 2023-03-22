package BoardMeet.Backend.Service;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotFoundCommentException;
import BoardMeet.Backend.Model.Comment;
import BoardMeet.Backend.dto.CommentCreateDTO;

public interface CommentService {
    Comment create(CommentCreateDTO comment);
    void delete(Long Id) throws NotFoundCommentException, NoAccessException;
    Comment get(Long Id) throws  NotFoundCommentException;
}
