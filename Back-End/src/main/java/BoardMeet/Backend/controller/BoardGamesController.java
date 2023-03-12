package BoardMeet.Backend.controller;

import BoardMeet.Backend.Exception.NotFoundBoardGameException;
import BoardMeet.Backend.Model.BoardGame;
import BoardMeet.Backend.Service.BoardGameService;
import BoardMeet.Backend.dto.BoardGameChangeDTO;
import BoardMeet.Backend.dto.BoardGameCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("{Id}")
    public ResponseEntity<?> get(@PathVariable Long Id){
        try {
            return new  ResponseEntity(boardGameService.get(Id),HttpStatus.OK);
        }catch (NotFoundBoardGameException e ){
            return  new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }
    }
    @PostMapping
    public  ResponseEntity<?> post(@RequestBody BoardGameCreateDTO boardGame){
        return new ResponseEntity(boardGameService.create(boardGame),HttpStatus.OK);
    }
    @PutMapping
    public  ResponseEntity<?> put(@RequestBody BoardGameChangeDTO boardGame){
        try {
            return new  ResponseEntity(boardGameService.change(boardGame),HttpStatus.OK);
        }catch (NotFoundBoardGameException e ){
            return  new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }
    }
    @DeleteMapping("{Id}")
    public  ResponseEntity<?> delete(@PathVariable Long Id){
        try {
            boardGameService.delete(Id);
            return new  ResponseEntity(HttpStatus.OK);
        }catch (NotFoundBoardGameException e ){
            return  new ResponseEntity(e.getMessage(),HttpStatus.OK);
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
