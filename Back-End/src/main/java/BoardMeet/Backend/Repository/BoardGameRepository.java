package BoardMeet.Backend.Repository;

import BoardMeet.Backend.Filter.BoardGameFilter;
import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Model.Meet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.List;

public interface BoardGameRepository extends JpaRepository<BoardGame,Long>, JpaSpecificationExecutor<BoardGame> {
    List<BoardGame> findByNameContains(String filter);
    List<BoardGame> findByGenre (String genre);
    @Query(nativeQuery = true,value = "select  board_game.* from board_game join (select board_game_id,sum(interest*cnt) as interestAll  from (SELECT * FROM \n" +
            "(select a.board_game_id,interest,user_id from recommendation  join (select board_game_id from recommendation where user_id = ?1 ) as a\n" +
            "on a.board_game_id = recommendation.board_game_id)as b) as t1 join\n" +
            "(select * from (select count(user_id) as cnt ,user_id from\n" +
            "(select recommendation.user_id,interest,a.board_game_id from recommendation  join (select user_id,board_game_id from recommendation where user_id = ?1  ) as a\n" +
            "on a.board_game_id = recommendation.board_game_id)as b group by user_id) as ass order by cnt DESC limit ?2) as t2 on t1.user_id = t2.user_id group by board_game_id) as c on c.board_game_id = board_game.id order by c.interestAll DESC  ",
            countQuery = "select  count(board_game.id) from board_game join (select board_game_id,sum(interest*cnt) as interestAll  from (SELECT * FROM \n" +
            "(select a.board_game_id,interest,user_id from recommendation  join (select board_game_id from recommendation where user_id = ?1 ) as a\n" +
            "on a.board_game_id = recommendation.board_game_id)as b) as t1 join\n" +
            "(select * from(select count(user_id) as cnt ,user_id from\n" +
            "(select recommendation.user_id,interest,a.board_game_id from recommendation  join (select user_id,board_game_id from recommendation where user_id = ?1  ) as a\n" +
            "on a.board_game_id = recommendation.board_game_id)as b group by user_id)as ass order by cnt DESC limit ?2) as t2 on t1.user_id = t2.user_id group by board_game_id) as c on c.board_game_id = board_game.id order by c.interestAll DESC  ")
    Page<BoardGame> getRecommendation(Long id,Long recommendationPeopleCount, Pageable page);

}
