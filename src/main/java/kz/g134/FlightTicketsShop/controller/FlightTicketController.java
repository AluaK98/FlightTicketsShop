package kz.g134.FlightTicketsShop.controller;

import jakarta.validation.Valid;
import kz.g134.FlightTicketsShop.dto.request.FlightTicketRequestDTO;
import kz.g134.FlightTicketsShop.dto.request.FlightTicketUpdateDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseFullDTO;
import kz.g134.FlightTicketsShop.service.FlightTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("v1/flight-tickets")
@RequiredArgsConstructor
public class FlightTicketController {
    private final FlightTicketService flightTicketService;

    @GetMapping
    public ResponseEntity<Page<FlightTicketResponseDTO>> getFlightTickets(
            @RequestParam(required = false) String name,
            @PageableDefault(size=2,sort="id",direction = Sort.Direction.ASC)
            Pageable pageable){
        return new ResponseEntity(flightTicketService.getAllFlightTickets(name,pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid FlightTicketRequestDTO dto) {
      return new ResponseEntity<>(flightTicketService.createFlightTicket(dto),HttpStatus.CREATED);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<FlightTicketResponseFullDTO> getFlightTicketById(@PathVariable Long id) {
        return new ResponseEntity<>(flightTicketService.getFlightTicketById(id),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid FlightTicketUpdateDTO dto) {
        return new ResponseEntity<>(flightTicketService.updateFlightTicket(dto),HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return new ResponseEntity<>(flightTicketService.deleteFlightTicket(id),HttpStatus.OK);
    }
}

