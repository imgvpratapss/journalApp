package net.engineeringdigest.journalApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkhealth")
public class HealthCheckController {

    @GetMapping
    public HttpStatus checkHealth(){
        return HttpStatus.OK;
    }
}
