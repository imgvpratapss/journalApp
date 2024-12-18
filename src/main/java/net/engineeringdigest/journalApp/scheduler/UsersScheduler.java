package net.engineeringdigest.journalApp.scheduler;

import lombok.var;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.repository.UserRepoImpl;
import net.engineeringdigest.journalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class UsersScheduler {

    @Autowired
    private EmailService mailService;

    @Autowired
    private UserRepoImpl userRepo;



    public void sendUserMail() {
       var users   =  userRepo.getUesrsFroSentimentAnalysis();
        users.stream().forEach(user -> {
            if(user.getEmail()!=null && !user.getEmail().isEmpty()) {
                ArrayList<JournalEntry> journalEntries ;
                List<String> entries = Collections.singletonList("");
                if(user.getJournalEntries()!=null && !user.getJournalEntries().isEmpty()) {
                     journalEntries = user.getJournalEntries();
                    entries = journalEntries.stream().map(j->j.getContent()).collect(Collectors.toList());
                }
                if(user.getEmail().contains("test"))
                    user.setEmail("imgvprataps@gmail.com");
                mailService.sendMail(user.getEmail(), "Scheduler Testing", user.getUserName() + " This email was sent to you to test the mail services and scheduler \n"
                   +entries.listIterator().next()+"\n");
            }
        });
    }
}
