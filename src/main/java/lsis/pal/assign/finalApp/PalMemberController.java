package lsis.pal.assign.finalApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pal-members")
public class PalMemberController {
    private PalMemberRepository palMemberRepo;

    public PalMemberController(PalMemberRepository palMemberRepo) {
        this.palMemberRepo = palMemberRepo;
    }

    @PostMapping
    public ResponseEntity<PalMember> create(@RequestBody PalMember palMember) {
        PalMember createdTimeEntry = palMemberRepo.create(palMember);

        return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PalMember> read(@PathVariable Long id) {
        PalMember palMember = palMemberRepo.find(id);
        if (palMember != null) {
            return new ResponseEntity<>(palMember, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<PalMember>> list() {
        return new ResponseEntity<>(palMemberRepo.list(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<PalMember> update(@PathVariable Long id, @RequestBody PalMember timeEntry) {
        PalMember updatedTimeEntry = palMemberRepo.update(id, timeEntry);
        if (updatedTimeEntry != null) {
            return new ResponseEntity<>(updatedTimeEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        palMemberRepo.delete(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
