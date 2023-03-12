package BoardMeet.Backend.Repository;

import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Model.Meet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardGameRepository extends JpaRepository<BoardGame,Long> {
    List<BoardGame> findByNameContains(String filter);
    List<BoardGame> findByGenre (String genre);
}
