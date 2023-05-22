package BoardMeet.Backend.Controller;

import BoardMeet.Backend.Exception.NoAccessException;
import BoardMeet.Backend.Exception.NotFoundMeetException;
import BoardMeet.Backend.Exception.NotFoundUserException;
import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.Service.MeetService;
import BoardMeet.Backend.DTO.MeetChangeDTO;
import BoardMeet.Backend.DTO.MeetCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/meets/")
public class MeetsController {
    @Autowired
    private final MeetService meetService;
    public MeetsController(MeetService meetService) {
        this.meetService = meetService;
    }
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                    @RequestParam(value = "limit",defaultValue = "20") Integer limit){

        return new ResponseEntity<>(meetService.getAll(PageRequest.of(offset,limit)),HttpStatus.OK);

    }
    @GetMapping("{Id}")
    public ResponseEntity<?> get(@PathVariable Long Id){
        try {
            return new ResponseEntity<>(meetService.get(Id),HttpStatus.OK);
        }catch (NotFoundMeetException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }
    @Secured({"ROLE_PLAYER","ROLE_ORGANIZATION"})
    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody MeetCreateDTO meetCreating){
        try {
            return new ResponseEntity<>(meetService.create(meetCreating), HttpStatus.OK);
        }catch (NoAccessException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @Secured({"ROLE_PLAYER","ROLE_ORGANIZATION"})
    @PutMapping
    public ResponseEntity<?> put(@Valid @RequestBody MeetChangeDTO meetChanging){
        try{
            Meet meetChanged =  meetService.change(meetChanging);
            return new ResponseEntity<>(meetChanged, HttpStatus.OK);
        }catch (NotFoundMeetException e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch (NoAccessException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @Secured({"ROLE_PLAYER","ROLE_ORGANIZATION","ROLE_ADMIN"})
    @DeleteMapping("{Id}")
    public  ResponseEntity<?> delete(@PathVariable  Long Id ){
        try {
            meetService.delete(Id);
            return  new ResponseEntity<>( HttpStatus.OK);
        }catch (NotFoundMeetException e){
            return  new ResponseEntity<>( e.getMessage(),HttpStatus.NOT_FOUND);
        }catch (NoAccessException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @Secured({"ROLE_PLAYER"})
    @PutMapping("{meetId}/exitUser/{userId}")
    public  ResponseEntity<?> exit(@PathVariable Long meetId,@PathVariable Long userId){
        try {

            return new ResponseEntity<>(meetService.exit(meetId,userId),HttpStatus.OK);
        }catch (NotFoundMeetException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (NoAccessException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @Secured({"ROLE_PLAYER"})
    @PutMapping("{meetId}/joinUser/{userId}")
    public  ResponseEntity<?> Join(@PathVariable Long meetId,@PathVariable Long userId){
        try {

            return new ResponseEntity<>(meetService.join(meetId,userId),HttpStatus.OK);
        }catch (NotFoundMeetException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch(NotFoundUserException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch (NoAccessException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @Secured({"ROLE_PLAYER","ROLE_ORGANIZATION"})
    @PutMapping("{Id}/lock")
    public  ResponseEntity<?> Lock(@PathVariable Long Id)throws NoAccessException {
        try {

            return new ResponseEntity<>(meetService.lock(Id),HttpStatus.OK);
        }catch (NotFoundMeetException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch (NoAccessException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @Secured({"ROLE_PLAYER","ROLE_ORGANIZATION"})
    @PutMapping("{Id}/open")
    public  ResponseEntity<?> Open(@PathVariable Long Id){
        try {
            return new ResponseEntity<>(meetService.open(Id),HttpStatus.OK);
        }catch (NotFoundMeetException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch (NoAccessException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("search/{searchVal}")
    public  ResponseEntity<?> Search(@PathVariable String searchVal){
        List<Meet> meets = meetService.search(searchVal);
        return  new ResponseEntity<>(meets,HttpStatus.OK);
    }
}
