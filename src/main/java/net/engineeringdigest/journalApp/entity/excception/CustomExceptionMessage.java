package net.engineeringdigest.journalApp.entity.excception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class CustomExceptionMessage {
    transient int code;
    transient String message;
    transient HttpStatus httpStatus;
}
