package kz.g134.FlightTicketsShop.service;

import kz.g134.FlightTicketsShop.dto.request.FlightTicketRequestDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseFullDTO;

import java.util.List;

public interface FlightTicketService {
    List<FlightTicketResponseDTO> getAllFlightTickets();

    Void createFlightTicket(FlightTicketRequestDTO dto);

    FlightTicketResponseFullDTO getFlightTicketById(Long id);
}
