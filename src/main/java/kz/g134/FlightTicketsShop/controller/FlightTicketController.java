package kz.g134.FlightTicketsShop.controller;

import jakarta.validation.Valid;
import kz.g134.FlightTicketsShop.dto.request.FlightTicketRequestDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseFullDTO;
import kz.g134.FlightTicketsShop.service.FlightTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("v1/flight-tickets")
@RequiredArgsConstructor
public class FlightTicketController {
    private final FlightTicketService flightTicketService;

    @GetMapping
    public ResponseEntity<List<FlightTicketResponseDTO>> getFlightTickets() {
        return new ResponseEntity(flightTicketService.getAllFlightTickets(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid FlightTicketRequestDTO dto) {
      return new ResponseEntity<>(flightTicketService.createFlightTicket(dto),HttpStatus.CREATED);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<FlightTicketResponseFullDTO> getFlightTicketById(@PathVariable Long id) {
        return new ResponseEntity<>(flightTicketService.getFlightTicketById(id),HttpStatus.OK);
    }

}

