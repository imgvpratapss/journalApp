package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.repository.UserRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkhealth")
public class HealthCheckController {
    @Autowired
    private UserRepoImpl userRepo;
    @GetMapping
    public HttpStatus checkHealth(){
        return HttpStatus.OK;
    }

    @GetMapping("/test")
    public ResponseEntity<?> getUsers(){
      return new ResponseEntity<>(userRepo.getUesrsFroSentimentAnalysis(),HttpStatus.OK) ;
    }
}
