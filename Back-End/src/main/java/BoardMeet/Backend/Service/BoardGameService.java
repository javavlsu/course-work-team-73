package BoardMeet.Backend.Service;

import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.dto.BoardGameChangeDTO;
import BoardMeet.Backend.dto.BoardGameCreateDTO;

import java.util.List;

public interface BoardGameService {
    List<BoardGame> getAll();
    BoardGame get(Long Id);
    BoardGame change(BoardGameChangeDTO boardGame);
    BoardGame create(BoardGameCreateDTO boardGame);
    boolean delete(Long Id);
    List<BoardGame> searchByName(String searchVal);
    List<BoardGame> filterByGenre(String genre);

}
