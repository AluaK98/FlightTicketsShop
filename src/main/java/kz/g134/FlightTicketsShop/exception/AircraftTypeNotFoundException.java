package kz.g134.FlightTicketsShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AircraftTypeNotFoundException extends RuntimeException {
    public AircraftTypeNotFoundException(String message) {
        super(message);
    }
}

