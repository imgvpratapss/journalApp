package net.engineeringdigest.journalApp.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class HealthCheckControllerTest {
    HealthCheckController healthCheckController = new HealthCheckController();

    @Test
    void testCheckHealth() {
        HttpStatus result = healthCheckController.checkHealth();
        Assertions.assertEquals(HttpStatus.CONTINUE, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
