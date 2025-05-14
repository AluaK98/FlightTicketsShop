package kz.g134.FlightTicketsShop.service;

import kz.g134.FlightTicketsShop.dto.request.FlightTicketRequestDTO;
import kz.g134.FlightTicketsShop.dto.request.FlightTicketUpdateDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseFullDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FlightTicketService {
    Page<FlightTicketResponseDTO> getAllFlightTickets(String name, Pageable pageable);

    Void createFlightTicket(FlightTicketRequestDTO dto);

    FlightTicketResponseFullDTO getFlightTicketById(Long id);

    Void updateFlightTicket(FlightTicketUpdateDTO dto);

    Void deleteFlightTicket(Long id);
}
