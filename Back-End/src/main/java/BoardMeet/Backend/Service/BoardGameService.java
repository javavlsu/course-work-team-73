package BoardMeet.Backend.Service;

import BoardMeet.Backend.Exception.NotFoundBoardGameException;
import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.dto.BoardGameChangeDTO;
import BoardMeet.Backend.dto.BoardGameCreateDTO;

import java.util.List;

public interface BoardGameService {
    List<BoardGame> getAll();
    BoardGame get(Long Id) throws NotFoundBoardGameException;
    BoardGame change(BoardGameChangeDTO boardGame) throws NotFoundBoardGameException;
    BoardGame create(BoardGameCreateDTO boardGame);
    void delete(Long Id) throws NotFoundBoardGameException;
    List<BoardGame> searchByName(String searchVal) ;
    List<BoardGame> filterByGenre(String genre) ;

}
