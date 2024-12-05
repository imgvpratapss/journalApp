package net.engineeringdigest.journalApp.cache;


import lombok.extern.slf4j.Slf4j;
import lombok.var;
import net.engineeringdigest.journalApp.entity.config.JournalConfig;
import net.engineeringdigest.journalApp.repository.ConfigJournalApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
@EnableScheduling
public class AppCache {
    public Map<String, String> cache ;
    @Autowired
    private ConfigJournalApp appConfig;

    @PostConstruct
    public void getCache() {
        cache = new HashMap<>();
        var allConfig=  appConfig.findAll();
        if(!allConfig.isEmpty()){
            for (JournalConfig journalConfig: allConfig) {
                if(journalConfig.getWeather()!=null) {
                    var weather = journalConfig.getWeather();
                    cache.put(weather.getKey(),weather.getValue());
                    cache.put("url",weather.getBase_url());
                }
            }
        }

    }
 //   @Scheduled(cron = "*/2 * * * * *")
    private void init(){
        log.trace("init called  "+ LocalDateTime.now());
        getCache();
    }
}
