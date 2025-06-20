package kz.g134.FlightTicketsShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LuggageNotFoundException extends RuntimeException {
    public LuggageNotFoundException(String message) {
        super(message);
    }
}
