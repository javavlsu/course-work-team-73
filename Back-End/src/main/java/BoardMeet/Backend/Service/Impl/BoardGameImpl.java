package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Service.BoardGameService;
import BoardMeet.Backend.dto.BoardGameChangeDTO;
import BoardMeet.Backend.dto.BoardGameCreateDTO;

import java.util.List;

public class BoardGameImpl implements BoardGameService {
    @Override
    public List<BoardGame> getAll() {
        return null;
    }

    @Override
    public BoardGame get(Long Id) {
        return null;
    }

    @Override
    public BoardGame change(BoardGameChangeDTO boardGame) {
        return null;
    }

    @Override
    public BoardGame create(BoardGameCreateDTO boardGame) {
        return null;
    }

    @Override
    public boolean delete(Long Id) {
        return false;
    }

    @Override
    public List<BoardGame> searchByName(String searchVal) {
        return null;
    }

    @Override
    public List<BoardGame> filterByGenre(String genre) {
        return null;
    }
}
