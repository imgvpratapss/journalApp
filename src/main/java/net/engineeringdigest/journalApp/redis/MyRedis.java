package net.engineeringdigest.journalApp.redis;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import net.engineeringdigest.journalApp.config.RdisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RdisConfig  rdisConfig;
   public   String sendMailToUsers() {
                redisTemplate.setValueSerializer(new StringRedisSerializer());
     //  redisTemplate.opsForValue().set("name","sanjay");
       log.info((String)redisTemplate.opsForValue().get("salary"));
       return (String) redisTemplate.opsForValue().get("name");
    }
}
