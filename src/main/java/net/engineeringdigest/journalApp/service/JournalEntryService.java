package net.engineeringdigest.journalApp.service;


import lombok.var;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo entryRepo;

    @Autowired
    private UserService userService;

    public User user(String username) {
        return userService.findByUserName(username).get();
    }

    @Transactional
    public Map<ObjectId, JournalEntry> saveJournalEntry(JournalEntry journalEntry, String username) {
        try {
            var user = user(username);
            var entry = entryRepo.save(journalEntry);
            var value = (Map) new HashMap<>();
            value.put(entry.getId(), entry);
            if (user.getJournalEntries() == null) {
                ArrayList entries = new ArrayList<>();
                entries.add(entry);
                user.setJournalEntries(entries);
            } else
                user.getJournalEntries().add(entry);
            //   userService.saveUser(user);
            userService.saveUser(user);
            return value;
        } catch (Exception e) {
            throw e;
        }

    }

    public Map<ObjectId, JournalEntry> saveJournalEntry(JournalEntry journalEntry) {
        var entry = entryRepo.save(journalEntry);
        var value = (Map) new HashMap<>();
        value.put(entry.getId(), entry);
        return value;

    }

    public List<Map> findAllEntries(String username) {
        var user = user(username);
        var entries = user.getJournalEntries(); //entryRepo.findAll();
        List<Map> list = new ArrayList<>();
        var item = (Map) new HashMap<>();
        if (entries != null && !entries.isEmpty())
            entries.stream().forEach(journalEntry -> {
                item.put(journalEntry.getId(), journalEntry);
            });
        list.add(item);
        return list;
    }

    public Optional<JournalEntry> findById(ObjectId jid) {
        return entryRepo.findById(jid);
    }
    @Transactional
    public Boolean deleteEntryById(ObjectId id, String username) {
        try {
            if (id != null) {
                User user = user(username);
                var value = user.getJournalEntries().removeIf(journalEntry -> journalEntry.getId().equals(id));
                if (value)
                    entryRepo.deleteById(id);
                userService.saveUser(user);
                return Boolean.TRUE;
            } else
                return Boolean.FALSE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//    public List<JournalEntry> findByUserName(String username){
//        entryRep
//    }
}
