package BoardMeet.Backend.Service;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotAccessExtensionException;
import BoardMeet.Backend.Exception.NotFoundBoardGameException;
import BoardMeet.Backend.Filter.BoardGameFilter;
import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.DTO.BoardGameChangeDTO;
import BoardMeet.Backend.DTO.BoardGameCreateDTO;
import BoardMeet.Backend.Model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardGameService {
    List<BoardGame> getAll();
    Page<BoardGame> getRecommendation(PageRequest pageable);

    Page<BoardGame> filter(BoardGameFilter filter, PageRequest pageRequest);
    BoardGame get(Long Id) throws NotFoundBoardGameException;
    BoardGame change(BoardGameChangeDTO boardGame) throws NotFoundBoardGameException,NotAccessExtensionException, NoAccessException;
    BoardGame create(BoardGameCreateDTO boardGame) throws NotAccessExtensionException, NoAccessException;
    void delete(Long Id) throws NotFoundBoardGameException, NoAccessException;
    List<BoardGame> searchByName(String searchVal) ;
    List<BoardGame> filterByGenre(String genre);
    void addRatingData(Comment comment);
    void removeRatingData(Comment comment);

}
