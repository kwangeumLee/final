package lsis.pal.assign.finalApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pal-members")
public class PalMemberController {

    private final PalMemberRepository palMemberRepo;
    public PalMemberController(PalMemberRepository palMemberRepo) {
        this.palMemberRepo = palMemberRepo;
    }

    @GetMapping("{id}")
    public ResponseEntity<PalMember> find(@PathVariable Long id) {
        Optional<PalMember> palMember = palMemberRepo.findById(id);
        ResponseEntity<PalMember> entity= null;

        if(palMember != null){
            entity = new ResponseEntity(palMember, HttpStatus.FOUND);
        }else{
            entity = new ResponseEntity(palMember, HttpStatus.NOT_FOUND);
        }
        return entity;
    }

    @GetMapping
    public ResponseEntity<List<PalMember>>  list(){
        return new ResponseEntity(palMemberRepo.findAll(),HttpStatus.ACCEPTED);
    }

    @PostMapping
    public String save(@RequestBody PalMember book){
        palMemberRepo.save(book);
        return "Book "+book+" added";
    }


}
