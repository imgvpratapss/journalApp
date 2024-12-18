package net.engineeringdigest.journalApp.radis;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.redis.MyRedis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class TestRedis {

    @Autowired
    private MyRedis myRedis;

    @Test
    void testMyRedis(){
        System.out.println(myRedis.sendMailToUsers());
    }
}
