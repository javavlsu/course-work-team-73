package BoardMeet.Backend.controller;

import BoardMeet.Backend.Exception.NotFoundMeetException;
import BoardMeet.Backend.Exception.NotFoundUserException;
import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.Service.MeetService;
import BoardMeet.Backend.dto.MeetChangeDTO;
import BoardMeet.Backend.dto.MeetCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(meetService.getAll(),HttpStatus.OK);
    }
    @GetMapping("{Id}")
    public ResponseEntity<?> get(@PathVariable Long Id){
        Meet meet =  meetService.get(Id);
        if (meet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(meet,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> post(@RequestBody MeetCreateDTO meetCreating){
        return new ResponseEntity<>(meetService.create(meetCreating), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody MeetChangeDTO meetChanging){
        try{
            Meet meetChanged =  meetService.change(meetChanging);
            return new ResponseEntity<>(meetChanged, HttpStatus.OK);
        }catch (NotFoundMeetException e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("{Id}")
    public  ResponseEntity<?> delete(@PathVariable  Long Id ){
        try {
            meetService.delete(Id);
        }catch (NotFoundMeetException e){
            return  new ResponseEntity<>( e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>( HttpStatus.OK);
    }
    @PutMapping("exit/{meetId}/user/{userId}")
    public  ResponseEntity<?> exit(@PathVariable Long meetId,@PathVariable Long userId){
        try {
            meetService.exit(meetId,userId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundMeetException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("join/{meetId}/user/{userId}")
    public  ResponseEntity<?> Join(@PathVariable Long meetId,@PathVariable Long userId){
        try {
            meetService.join(meetId,userId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundMeetException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch(NotFoundUserException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("lock/{meetId}")
    public  ResponseEntity<?> Lock(@PathVariable Long meetId){
        try {
            meetService.lock(meetId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundMeetException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("open/{meetId}")
    public  ResponseEntity<?> Open(@PathVariable Long meetId){
        try {
            meetService.open(meetId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundMeetException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("search/{searchVal}")
    public  ResponseEntity<?> Search(@PathVariable String searchVal){
        List<Meet> meets = meetService.search(searchVal);
        return  new ResponseEntity<>(meets,HttpStatus.OK);

    }
}
