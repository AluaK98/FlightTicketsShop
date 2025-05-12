package kz.g134.FlightTicketsShop.controller;

import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseDTO;
import kz.g134.FlightTicketsShop.service.FlightTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/flight_tickets")
@RequiredArgsConstructor
public class FlightTicketController {
    private final FlightTicketService flightTicketService;


    @GetMapping
    public ResponseEntity<List<FlightTicketResponseDTO>> getFlightTickets() {
        return ResponseEntity.ok(flightTicketService.getAllFlightTickets());
    }
}

