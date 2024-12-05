package net.engineeringdigest.journalApp.service;

import lombok.extern.log4j.Log4j2;
import lombok.var;
import net.engineeringdigest.journalApp.pojo.labs11.ElevenLabsPojo;
import net.engineeringdigest.journalApp.pojo.labs11.voice.VoiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.sound.sampled.spi.AudioFileReader;
import java.util.ArrayList;

@Log4j2
@Service
public class ElevenLabsServices {

    @Autowired
    private RestTemplate template;

    @Value("${11Labs.api_key}")
    private String apiKey;

    @Value("${11Labs.url}")
    private String baseUrl;

    public String textToSpeech(ElevenLabsPojo labsPojo)  {
        return getTextToVoice(labsPojo);
    }

    public ArrayList<?> getVoices() {
        var response = template.exchange(baseUrl + "voices", HttpMethod.GET, null, VoiceResponse.class);
        return response.getBody().getVoices();
    }

    public String getTextToVoice(ElevenLabsPojo labsPojo)  {

        try {
            var headers = getHeader();
            HttpEntity httpEntity = new HttpEntity(labsPojo, headers);
            var response = template.exchange(baseUrl + "text-to-speech/" + labsPojo.getVoiceId(), HttpMethod.POST, httpEntity, AudioFileReader.class);
            return response.getBody().toString();
        } catch (HttpClientErrorException e) {
            throw new RestClientException( e.getMessage());
        }

    }

    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("xi-api-key", apiKey);
        headers.add("Content-Type", "audio/mpeg");
        return headers;
    }
}
