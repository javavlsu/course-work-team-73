package BoardMeet.Backend.Service;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotAccessExtensionException;
import BoardMeet.Backend.Exception.NotFoundBoardGameException;
import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.DTO.BoardGameChangeDTO;
import BoardMeet.Backend.DTO.BoardGameCreateDTO;

import java.util.List;

public interface BoardGameService {
    List<BoardGame> getAll();
    List<BoardGame> getRecommendation();
    BoardGame get(Long Id) throws NotFoundBoardGameException;
    BoardGame change(BoardGameChangeDTO boardGame) throws NotFoundBoardGameException,NotAccessExtensionException, NoAccessException;
    BoardGame create(BoardGameCreateDTO boardGame) throws NotAccessExtensionException, NoAccessException;
    void delete(Long Id) throws NotFoundBoardGameException, NoAccessException;
    List<BoardGame> searchByName(String searchVal) ;
    List<BoardGame> filterByGenre(String genre) ;

}
