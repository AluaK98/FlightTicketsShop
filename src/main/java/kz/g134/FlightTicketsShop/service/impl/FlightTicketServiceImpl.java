package kz.g134.FlightTicketsShop.service.impl;

import jakarta.transaction.Transactional;
import kz.g134.FlightTicketsShop.dto.request.FlightTicketRequestDTO;
import kz.g134.FlightTicketsShop.dto.request.FlightTicketUpdateDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseFullDTO;
import kz.g134.FlightTicketsShop.entity.FlightTicket;
import kz.g134.FlightTicketsShop.exception.FlightTicketNotFoundException;
import kz.g134.FlightTicketsShop.mapper.FlightTicketMapper;
import kz.g134.FlightTicketsShop.repository.FlightTicketRepository;
import kz.g134.FlightTicketsShop.service.FlightTicketService;
import kz.g134.FlightTicketsShop.util.FlightTicketSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<FlightTicketResponseDTO> getAllFlightTickets(String name, Pageable pageable) {
        Page<FlightTicket> flightTickets = flightTicketRepository.findAll(FlightTicketSpecification.getItemSpecification(name),pageable);
        return flightTicketMapper.map(flightTickets);
    }

    @Override
    public Void createFlightTicket(FlightTicketRequestDTO dto) {
        flightTicketRepository.save(flightTicketMapper.toFlightTicket(dto));
        return null;
    }

    @Override
    public FlightTicketResponseFullDTO getFlightTicketById(Long id) {
        return flightTicketMapper.toFullDTO(flightTicketRepository.findById(id).orElseThrow(() -> new FlightTicketNotFoundException("Flight Ticket not found")));
    }

    @Override
    public Void updateFlightTicket(FlightTicketUpdateDTO dto) {
        FlightTicket flightTicket = flightTicketMapper.toFlightTicket(dto);
        flightTicketRepository.save(flightTicket);
        return null;
    }

    @Override
    public Void deleteFlightTicket(Long id) {
        flightTicketRepository.deleteById(id);
        return null;
    }
}