package net.engineeringdigest.journalApp.controller.elevenlabs;

import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.pojo.labs11.ElevenLabsPojo;
import net.engineeringdigest.journalApp.service.ElevenLabsServices;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("speech")
@Slf4j
public class TextToSpeechController {

    @Autowired
    private ElevenLabsServices services;

    @GetMapping("/voice")
    public ResponseEntity<?> voices() throws UnirestException {
        return new ResponseEntity<>( services.getVoices(),HttpStatus.OK);
    }


    @PostMapping("/voice")
    public ResponseEntity<?> textToSpeech(@RequestBody ElevenLabsPojo labsPojo)  {
        return new ResponseEntity<>(services.textToSpeech(labsPojo),HttpStatus.CREATED);
    }
    @PostMapping("/voice-with-timing")
    public ResponseEntity<?> createAdmin(@RequestBody ElevenLabsPojo labsPojo)  {
        services.textToSpeech(labsPojo);
               return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
