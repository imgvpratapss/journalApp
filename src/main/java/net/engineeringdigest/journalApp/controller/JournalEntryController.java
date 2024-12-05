package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("/id")
    public JournalEntry getById(@RequestParam Long jid) {
        return  journalEntries.get(jid);
    }

//    @PostMapping
//    public Map<Long, JournalEntry> createEntry(@RequestBody JournalEntry journalEntry) {
//        if (journalEntry == null)
//            journalEntries.put(1L, JournalEntry.builder()
//                    .id(1).title("entry").content("hi this is new  entry").build());
//        else
//            journalEntries.put((long) journalEntry.getId(), journalEntry);
//        return journalEntries;
//    }


}