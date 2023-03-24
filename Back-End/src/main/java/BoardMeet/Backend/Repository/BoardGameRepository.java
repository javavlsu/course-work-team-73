package BoardMeet.Backend.Repository;

import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Model.Meet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface BoardGameRepository extends JpaRepository<BoardGame,Long> {
    List<BoardGame> findByNameContains(String filter);
    List<BoardGame> findByGenre (String genre);
    @Query(nativeQuery = true,value = "select  board_game.* from boardmeet.board_game join (select board_game_id,sum(interest*cnt) as interestAll  from (SELECT * FROM \n" +
            "(select a.board_game_id,interest,user_id from boardmeet.recommendation  join (select board_game_id from boardmeet.recommendation where user_id = ?1 ) as a\n" +
            "on a.board_game_id = boardmeet.recommendation.board_game_id)as b) as t1 join\n" +
            "(select count(user_id) as cnt ,user_id from\n" +
            "(select boardmeet.recommendation.user_id,interest,a.board_game_id from boardmeet.recommendation  join (select user_id,board_game_id from boardmeet.recommendation where user_id = ?1  ) as a\n" +
            "on a.board_game_id = boardmeet.recommendation.board_game_id)as b group by user_id) as t2 on t1.user_id = t2.user_id group by board_game_id) as c on c.board_game_id = board_game.id order by c.interestAll DESC")
    List<BoardGame> getRecommendation(Long id);
}
