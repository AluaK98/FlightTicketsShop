package kz.g134.FlightTicketsShop.service;

import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseDTO;

import java.util.List;

public interface FlightTicketService {
    List<FlightTicketResponseDTO> getAllFlightTickets();
}
