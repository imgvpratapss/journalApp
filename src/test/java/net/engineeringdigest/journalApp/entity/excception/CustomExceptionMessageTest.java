package net.engineeringdigest.journalApp.entity.excception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class CustomExceptionMessageTest {
    //Field httpStatus of type HttpStatus - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    CustomExceptionMessage customExceptionMessage = new CustomExceptionMessage(0, "message", HttpStatus.CONTINUE);

    @Test
    void testSetCode() {
        customExceptionMessage.setCode(0);
    }

    @Test
    void testSetMessage() {
        customExceptionMessage.setMessage("message");
    }

    @Test
    void testSetHttpStatus() {
        customExceptionMessage.setHttpStatus(HttpStatus.CONTINUE);
    }

    @Test
    void testBuilder() {
        CustomExceptionMessage.CustomExceptionMessageBuilder result = CustomExceptionMessage.builder();
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
