package kz.g134.FlightTicketsShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClassTypeNotFoundException extends RuntimeException {
    public ClassTypeNotFoundException(String message) {
        super(message);
    }
}
