package kz.g134.FlightTicketsShop.controller;

import kz.g134.FlightTicketsShop.entity.Direction;
import kz.g134.FlightTicketsShop.service.DirectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/directions")
@RequiredArgsConstructor
public class DirectionsController {
    private final DirectionsService directionsService;

    @GetMapping
    public ResponseEntity<List<Direction>> getDirections() {
        return new ResponseEntity<>(directionsService.getAll(), HttpStatus.OK);
    }
}
