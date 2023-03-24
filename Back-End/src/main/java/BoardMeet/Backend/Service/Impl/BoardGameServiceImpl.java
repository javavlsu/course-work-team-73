package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotAccessExtensionException;
import BoardMeet.Backend.Exception.NotFoundBoardGameException;
import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Repository.BoardGameRepository;
import BoardMeet.Backend.Service.BoardGameService;
import BoardMeet.Backend.Service.ControllAccessService;
import BoardMeet.Backend.Service.FileService;
import BoardMeet.Backend.Service.RecommendationService;
import BoardMeet.Backend.DTO.BoardGameChangeDTO;
import BoardMeet.Backend.DTO.BoardGameCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class BoardGameServiceImpl implements BoardGameService {

    @Autowired
    private final BoardGameRepository boardGameRepository;

    @Autowired
    private  final FileService fileService;
    @Autowired
    private  final ControllAccessService controllAccessService;

    @Autowired
    private  final RecommendationService recommendationService;
    public BoardGameServiceImpl(BoardGameRepository boardGameRepository, FileService fileService, ControllAccessService controllAccessService, RecommendationService recommendationService) {
        this.boardGameRepository = boardGameRepository;
        this.fileService = fileService;
        this.controllAccessService = controllAccessService;
        this.recommendationService = recommendationService;
    }

    @Override
    public List<BoardGame> getAll() {
        return boardGameRepository.findAll();
    }

    @Override
    public List<BoardGame> getRecommendation() {
        Long id = controllAccessService.getIdUser();
        if(id <= 0 ){
            return boardGameRepository.findAll(Sort.by(Sort.Direction.DESC, "ratingUser"));
        }
        List<BoardGame> bgs = boardGameRepository.getRecommendation(id);
        if(bgs.isEmpty() == true ){
            return boardGameRepository.findAll(Sort.by(Sort.Direction.DESC, "ratingUser"));
        }
        return bgs;
    }

    @Override
    public BoardGame get(Long id) throws NotFoundBoardGameException {
        BoardGame boardGame = boardGameRepository.findById(id).orElseThrow(()->new NotFoundBoardGameException("Board game by id : " + id +" Not Found"));
        recommendationService.changeByFollowingLink(id);
        return boardGame;
    }

    @Override
    public BoardGame change(BoardGameChangeDTO boardGame) throws NotFoundBoardGameException, NotAccessExtensionException, NoAccessException {
        BoardGame boardGameChanging = boardGameRepository.findById(boardGame.getId()).orElseThrow(()-> new NotFoundBoardGameException("Board game by id : " + boardGame.getId() +" Not Found"));
        controllAccessService.tryAccess(boardGameChanging.getAuthorId());
        if(boardGame.getAvatarGame() != null) {
            try {
                boardGameChanging.setGameAvatar(fileService.uploadBoardGameAvatar(boardGame.getAvatarGame()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NotAccessExtensionException e) {
                throw e;
            }
        }
        if(boardGame.getRule() != null) {
            try {
                boardGameChanging.setRule(fileService.uploadRule(boardGame.getRule()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NotAccessExtensionException e) {
                throw e;
            }
        }
        boardGameChanging.change(boardGame);
        boardGameRepository.save(boardGameChanging);
        return  boardGameChanging;
    }

    @Override
    public BoardGame create( BoardGameCreateDTO boardGame) throws NotAccessExtensionException, NoAccessException {
        BoardGame boardGameCreating = new BoardGame(boardGame);
        controllAccessService.tryAccess(boardGameCreating.getAuthorId());
        try {
            boardGameCreating.setGameAvatar(fileService.uploadBoardGameAvatar(boardGame.getAvatarGame()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NotAccessExtensionException e) {
            throw e;
        }
        try {
            boardGameCreating.setRule(fileService.uploadRule(boardGame.getRule()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NotAccessExtensionException e) {
            throw e;
        }
        boardGameRepository.save(boardGameCreating);

        return  boardGameCreating;
    }

    @Override
    public void delete(Long id) throws NotFoundBoardGameException, NoAccessException {
        BoardGame boardGameDeleting = boardGameRepository.findById(id).orElseThrow(()->new NotFoundBoardGameException("Board game by id : " + id +" Not Found"));
        controllAccessService.tryAccess(boardGameDeleting.getAuthorId());
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