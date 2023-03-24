package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotFoundCommentException;
import BoardMeet.Backend.Model.Comment;
import BoardMeet.Backend.Repository.CommentRepository;
import BoardMeet.Backend.Service.CommentService;
import BoardMeet.Backend.Service.ControllAccessService;
import BoardMeet.Backend.Service.RecommendationService;
import BoardMeet.Backend.DTO.CommentCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private  final CommentRepository commentRepository;
    @Autowired
    private  final RecommendationService recommendationService;

    @Autowired
    private  final  ControllAccessService controllAccessService;

    public CommentServiceImpl(CommentRepository commentRepository, RecommendationService recommendationService, ControllAccessService controllAccessService) {
        this.commentRepository = commentRepository;
        this.recommendationService = recommendationService;
        this.controllAccessService = controllAccessService;
    }

    @Override
    public Comment create(CommentCreateDTO comment) throws NoAccessException {
        Comment commentCreating = new Comment(comment);

        controllAccessService.tryAccess(comment.getAuthorId());
        commentRepository.save(commentCreating);
        recommendationService.changeByComment(comment);
        return commentCreating;
    }

    @Override
    public void delete(Long id) throws  NotFoundCommentException {
        Comment comment = commentRepository.findById(id).orElseThrow(()->new NotFoundCommentException("Comment by id : " + id +" Not Found"));
        commentRepository.delete(comment);
    }

    @Override
    public Comment get(Long id) throws NotFoundCommentException {
        Comment comment = commentRepository.findById(id).orElseThrow(()->new NotFoundCommentException("Comment by id : " + id +" Not Found"));
        return comment;
    }
}
