package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.scheduler.UsersScheduler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UsersScheduler usersScheduler;

    @Test
    void sendTestMail(){
        emailService.sendMail("yadav.vijaypratapsingh@gmail.com", "TEst", "Hi vijay");
    }

    @Test
    void sendTestMailScheduler(){
        usersScheduler.sendUserMail();
    }
}
