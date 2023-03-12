package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Exception.NotFoundCommentException;
import BoardMeet.Backend.Model.Comment;
import BoardMeet.Backend.Repository.CommentRepository;
import BoardMeet.Backend.Service.CommentService;
import BoardMeet.Backend.dto.CommentCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private  final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment create(CommentCreateDTO comment) {
        Comment commentCreating = new Comment(comment);
        commentRepository.save(commentCreating);
        return commentCreating;
    }

    @Override
    public void delete(Long Id) throws  NotFoundCommentException {
        Comment comment = commentRepository.findById(Id).orElse(null);
        if(comment == null){
            throw  new NotFoundCommentException("Comment by id : " + Id +" Not Found");
        }
        commentRepository.delete(comment);

    }

    @Override
    public Comment get(Long Id) throws NotFoundCommentException {
        Comment comment = commentRepository.findById(Id).orElse(null);
        if(comment == null){
            throw  new NotFoundCommentException("Comment by id : " + Id +" Not Found");
        }
        return comment;
    }
}
