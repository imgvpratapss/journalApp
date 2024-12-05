package net.engineeringdigest.journalApp.controller;

import lombok.var;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.entity.excception.CustomExceptionMessage;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import net.engineeringdigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal_new")
public class JournalController {

    @Autowired
    private JournalEntryService entryService;




    @GetMapping
    public List<Map> getAllJournalEntriesOfUser() {
        var authentication=  SecurityContextHolder.getContext().getAuthentication();
        var username = authentication.getName();
        return entryService.findAllEntries(username);
    }

    @GetMapping("/id")
    public ResponseEntity<Object> getById(@RequestParam ObjectId jid)  {
        var authentication=  SecurityContextHolder.getContext().getAuthentication();
        var username = authentication.getName();
        User user=  entryService.user(username);
        var entries= user.getJournalEntries().stream().filter(j-> j.getId().equals(jid)).collect(Collectors.toList());
        ResponseEntity<Object> responseEntity;
        if(!entries.isEmpty()){
            responseEntity=    entryService.findById(jid).map(entry-> new ResponseEntity<>((Object)entry , HttpStatus.OK)).orElseGet(()-> new ResponseEntity<>(JournalEntry.builder().message(CustomExceptionMessage.builder().message("").code(HttpStatus.NOT_FOUND.value()).httpStatus(HttpStatus.NOT_FOUND).build()).build(),HttpStatus.NOT_FOUND));
        }else
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        return entryService.findById(jid).map(entry-> new ResponseEntity<>((Object)entry , HttpStatus.OK)).orElseThrow(()-> CustomExceptionMessage.builder().message("Error").code(HttpStatus.NOT_FOUND.value()).httpStatus(HttpStatus.NOT_FOUND).build() );
        return responseEntity;
    }

    @PostMapping
    public Map<ObjectId, JournalEntry> createEntry(@RequestBody JournalEntry journalEntry ) {
        var authentication=  SecurityContextHolder.getContext().getAuthentication();
         var username = authentication.getName();
       return entryService.saveJournalEntry(journalEntry,username);
    }

    @PutMapping("id/{id}")
    public Map<ObjectId, JournalEntry> updateEntry(@PathVariable ObjectId id,@RequestBody JournalEntry journalEntry)  {

        var oldEntry= (JournalEntry)  getById(id).getBody();
        if(oldEntry==null)
            throw new NullPointerException("No record found");
        if(oldEntry!=null) {
            oldEntry.setTitle(journalEntry.getTitle()!=null && !journalEntry.getTitle().equals("")? journalEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(journalEntry.getContent()!=null && !journalEntry.getContent().equals("")? journalEntry.getContent() : oldEntry.getContent());
        }
        return entryService.saveJournalEntry(oldEntry);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteEntry(@PathVariable ObjectId id ){
        var authentication=  SecurityContextHolder.getContext().getAuthentication();
        var username = authentication.getName();
        var value= entryService.deleteEntryById(id,username);
        if(value)
            return  new ResponseEntity<>(value,HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(value,HttpStatus.BAD_REQUEST);
    }


}
