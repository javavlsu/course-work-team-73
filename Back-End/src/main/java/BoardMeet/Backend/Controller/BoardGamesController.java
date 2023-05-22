package BoardMeet.Backend.Controller;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotAccessExtensionException;
import BoardMeet.Backend.Exception.NotFoundBoardGameException;
import BoardMeet.Backend.Filter.BoardGameFilter;
import BoardMeet.Backend.Service.BoardGameService;
import BoardMeet.Backend.DTO.BoardGameChangeDTO;
import BoardMeet.Backend.DTO.BoardGameCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/boardGames/")
public class BoardGamesController {
    @Autowired
    private final BoardGameService boardGameService;

    public BoardGamesController(BoardGameService boardGameService) {
        this.boardGameService = boardGameService;
    }
    @GetMapping("recommendation/{id}")
    public ResponseEntity<?> getRecommendation(@PathVariable Long id,@RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                               @RequestParam(value = "limit",defaultValue = "20") Integer limit){
        return  new ResponseEntity<>(boardGameService.getRecommendation(PageRequest.of(offset,limit)),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> filter(BoardGameFilter boardGameFilter,@RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                    @RequestParam(value = "limit",defaultValue = "20") Integer limit){

        return new ResponseEntity<>(boardGameService.filter(boardGameFilter, PageRequest.of(offset,limit)),HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        try {
            return new  ResponseEntity<>(boardGameService.get(id),HttpStatus.OK);
        }catch (NotFoundBoardGameException e ){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
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
    @Secured("{ROLE_PUBLISHER,ROLE_ADMIN}")
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
}
