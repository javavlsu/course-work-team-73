package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Model.Recommendation;
import BoardMeet.Backend.Repository.RecommendationRepository;
import BoardMeet.Backend.Service.ControllAccessService;
import BoardMeet.Backend.Service.RecommendationService;
import BoardMeet.Backend.DTO.CommentCreateDTO;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private  final RecommendationRepository recommendationRepository;
    private  final ControllAccessService controllAccessService;
    public RecommendationServiceImpl(RecommendationRepository recommendationRepository, ControllAccessService controllAccessService) {
        this.recommendationRepository = recommendationRepository;
        this.controllAccessService = controllAccessService;
    }


    @Override
    public void changeByComment(CommentCreateDTO comment) {
        Recommendation r =  recommendationRepository.findByUserAndBoardGame(comment.getAuthorId(),comment.getGameId());
        if(r == null){
            r = new Recommendation(comment);
        }
        r.setInterest(r.getInterest()+20);
        recommendationRepository.save(r);
    }

    @Override
    public void changeByFollowingLink(Long boardGameId) {
        Long id = controllAccessService.getIdUser();
        if (id <= 0){
            return;
        }
        Recommendation r =  recommendationRepository.findByUserAndBoardGame(controllAccessService.getIdUser(),boardGameId);
        if(r == null){
            r = new Recommendation(boardGameId,id);
        }
        r.setInterest(r.getInterest()+1);
        recommendationRepository.save(r);
    }
}
