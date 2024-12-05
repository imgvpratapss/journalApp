package net.engineeringdigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.pojo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class WeatherServices {

    @Value("${weather.api_key}")
    private String key;

    @Value("${weather.base_url}")
    private String base_url;

    @Autowired
    private  AppCache appCache;
    @Autowired
    private RestTemplate template;
    @Value("${weather.weather_type[0]}")
    public String [] weather_type;
    public List<?> getTemp(ArrayList<String> cites) {
        ArrayList<Weather> weathers = new ArrayList<>();
        Weather weather = new Weather();
        if(cites==null|| cites.isEmpty()){
            cites.add("Delhi");
        }
        for (String city: cites) {
            weather= template.exchange(appCache.cache.get("url")+Arrays.stream(weather_type).findFirst().get()
                            +"?access_key="+appCache.cache.get("api_key")
                            +"&query="+city
                    , HttpMethod.GET,null, Weather.class ).getBody();
            weathers.add(weather);
        }
//        weather= template.exchange(appCache.cache.get("url")+Arrays.stream(weather_type).findFirst().get()
//                        +"?access_key="+appCache.cache.get("api_key")
//                        +"&query="+cites.get(0)
//                , HttpMethod.GET,null, Weather.class ).getBody();
//        weathers.add(weather);

        return weathers;
    }
}
