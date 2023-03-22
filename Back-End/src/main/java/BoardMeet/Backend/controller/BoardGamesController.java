package BoardMeet.Backend.controller;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotAccessExtensionException;
import BoardMeet.Backend.Exception.NotFoundBoardGameException;
import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Service.BoardGameService;
import BoardMeet.Backend.dto.BoardGameChangeDTO;
import BoardMeet.Backend.dto.BoardGameCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/boardGame/")
public class BoardGamesController {
    @Autowired
    private final BoardGameService boardGameService;

    public BoardGamesController(BoardGameService boardGameService) {
        this.boardGameService = boardGameService;
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return  new ResponseEntity<>(boardGameService.getAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        try {
            return new  ResponseEntity(boardGameService.get(id),HttpStatus.OK);
        }catch (NotFoundBoardGameException e ){
            return  new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }
    }
    @Secured("ROLE_PUBLISHER")
    @PostMapping
    public  ResponseEntity<?> post(@Valid @ModelAttribute BoardGameCreateDTO boardGame){

        try {
            return new ResponseEntity(boardGameService.create(boardGame),HttpStatus.OK);
        }catch (NotAccessExtensionException e) {
            return new  ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        } catch (NoAccessException e) {
            return new  ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_PUBLISHER")
    @PutMapping
    public  ResponseEntity<?> put(@Valid @ModelAttribute BoardGameChangeDTO boardGame){
        try {
            return new  ResponseEntity(boardGameService.change(boardGame),HttpStatus.OK);
        }catch (NotFoundBoardGameException e ){
            return  new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }catch (NotAccessExtensionException e) {
            return new  ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        } catch (NoAccessException e) {
            return new  ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @Secured("ROLE_PUBLISHER")
    @DeleteMapping("{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id){
        try {
            boardGameService.delete(id);
            return new  ResponseEntity(HttpStatus.OK);
        }catch (NotFoundBoardGameException e ){
            return  new ResponseEntity(e.getMessage(),HttpStatus.OK);
        } catch (NoAccessException e) {
            return new  ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("search/{searchVal}")
    public  ResponseEntity<?> search(@PathVariable String searchVal){
        return new ResponseEntity(boardGameService.searchByName(searchVal),HttpStatus.OK);
    }
    @GetMapping("filter/{genre}")
    public  ResponseEntity<?> filter(@PathVariable String genre){
        return new ResponseEntity(boardGameService.filterByGenre(genre),HttpStatus.OK);
    }
}
