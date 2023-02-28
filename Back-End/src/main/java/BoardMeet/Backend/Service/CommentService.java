package BoardMeet.Backend.Service;

import BoardMeet.Backend.Model.Comment;
import BoardMeet.Backend.dto.CommentCreateDTO;

public interface CommentService {
    Comment create(CommentCreateDTO comment);
    boolean delete(Long Id);
    Comment get(Long Id);
}
