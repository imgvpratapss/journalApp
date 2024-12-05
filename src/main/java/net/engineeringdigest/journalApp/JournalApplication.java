package net.engineeringdigest.journalApp;


import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@Log4j2
public class JournalApplication {

    public static void main(String[] args) {
        var cac =SpringApplication.run(JournalApplication.class, args);
        log.info(cac.getEnvironment().getActiveProfiles());
    }


}
