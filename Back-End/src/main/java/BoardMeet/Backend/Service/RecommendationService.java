package BoardMeet.Backend.Service;

import BoardMeet.Backend.DTO.CommentCreateDTO;

public interface RecommendationService {
    void changeByComment(CommentCreateDTO comment);
    void changeByFollowingLink(Long boardGameId);
}
