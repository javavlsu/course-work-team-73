package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Exception.NotFoundBoardGameException;
import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Repository.BoardGameRepository;
import BoardMeet.Backend.Service.BoardGameService;
import BoardMeet.Backend.dto.BoardGameChangeDTO;
import BoardMeet.Backend.dto.BoardGameCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BoardGameServiceImpl implements BoardGameService {

    @Autowired
    private final BoardGameRepository boardGameRepository;

    public BoardGameServiceImpl(BoardGameRepository boardGameRepository) {
        this.boardGameRepository = boardGameRepository;
    }

    @Override
    public List<BoardGame> getAll() {
        return boardGameRepository.findAll();
    }

    @Override
    public BoardGame get(Long Id) throws NotFoundBoardGameException {
        BoardGame boardGame = boardGameRepository.findById(Id).orElse(null);
        if(boardGame == null){
            throw new NotFoundBoardGameException("Board game by id : " + Id +" Not Found");
        }
        return boardGame;
    }

    @Override
    public BoardGame change(BoardGameChangeDTO boardGame) throws NotFoundBoardGameException {
        BoardGame boardGameChanging = boardGameRepository.findById(boardGame.getId()).orElse(null);
        if(boardGameChanging == null){
            throw new NotFoundBoardGameException("Board game by id : " + boardGame.getId() +" Not Found");
        }
        boardGameChanging.change(boardGame);
        boardGameRepository.save(boardGameChanging);
        return  boardGameChanging;
    }

    @Override
    public BoardGame create(BoardGameCreateDTO boardGame) {
        BoardGame boardGameCreating = new BoardGame(boardGame);
        boardGameRepository.save(boardGameCreating);
        return  boardGameCreating;
    }

    @Override
    public void delete(Long Id) throws NotFoundBoardGameException {
        BoardGame boardGameDeleting = boardGameRepository.findById(Id).orElse(null);
        if(boardGameDeleting == null){
            throw  new NotFoundBoardGameException("Board game by id : " + Id +" Not Found");
        }
        boardGameRepository.delete(boardGameDeleting);
    }

    @Override
    public List<BoardGame> searchByName(String searchVal) {
        return boardGameRepository.findByNameContains(searchVal);
    }

    @Override
    public List<BoardGame> filterByGenre(String genre) {
        return boardGameRepository.findByGenre(genre);
    }
}