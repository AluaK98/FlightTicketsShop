package kz.g134.FlightTicketsShop.service;

import jakarta.transaction.Transactional;
import kz.g134.FlightTicketsShop.dto.request.FlightTicketRequestDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseFullDTO;
import kz.g134.FlightTicketsShop.exception.FlightTicketNotFoundException;
import kz.g134.FlightTicketsShop.mapper.FlightTicketMapper;
import kz.g134.FlightTicketsShop.repository.FlightTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FlightTicketServiceImpl implements FlightTicketService {

    private final FlightTicketRepository flightTicketRepository;
    private final FlightTicketMapper flightTicketMapper;

    @Override
    public List<FlightTicketResponseDTO> getAllFlightTickets() {
        return flightTicketRepository.findAll().stream()
                .map(flightTicketMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Void createFlightTicket(FlightTicketRequestDTO dto) {
        flightTicketRepository.save(flightTicketMapper.toFlightTicket(dto));
        return null;
    }

    @Override
    public FlightTicketResponseFullDTO getFlightTicketById(Long id) {
        return flightTicketMapper.toFullDTO(flightTicketRepository.findById(id).orElseThrow(()-> new FlightTicketNotFoundException("Flight Ticket not found")));
    }
}