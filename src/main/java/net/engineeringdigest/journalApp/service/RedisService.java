package net.engineeringdigest.journalApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import net.engineeringdigest.journalApp.pojo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    public <T> T get(String key, Class<T> t){
      var expireTime=   getKeyTimeout(key);
        Object o = redisTemplate.opsForValue().get(key);
        if(o!=null) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(o.toString(), t);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        else
            return null;
    }

    public void set(String city, Weather weather, long l, TimeUnit timeUnit) throws JsonProcessingException {
        redisTemplate.opsForValue().set(city,new ObjectMapper().writeValueAsString(weather),l,timeUnit);
    }

    public Long getKeyTimeout(String key) {
        // Get the expiration time of the key in SECONDS
        return redisTemplate.getExpire(key);
    }
}
