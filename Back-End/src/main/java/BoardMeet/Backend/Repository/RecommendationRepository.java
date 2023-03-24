package BoardMeet.Backend.Repository;

import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.Model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM recommendation WHERE user_id = ?1 and board_game_id = ?2 ")
    Recommendation findByUserAndBoardGame(Long userId, Long boardGameId);
}
