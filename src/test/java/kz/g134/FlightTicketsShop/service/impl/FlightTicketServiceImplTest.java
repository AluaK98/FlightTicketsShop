package kz.g134.FlightTicketsShop.service.impl;

import kz.g134.FlightTicketsShop.dto.request.FlightTicketRequestDTO;
import kz.g134.FlightTicketsShop.dto.request.FlightTicketUpdateDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseFullDTO;
import kz.g134.FlightTicketsShop.entity.FlightTicket;
import kz.g134.FlightTicketsShop.exception.FlightTicketNotFoundException;
import kz.g134.FlightTicketsShop.mapper.FlightTicketMapper;
import kz.g134.FlightTicketsShop.repository.FlightTicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@ExtendWith(MockitoExtension.class)
    class FlightTicketServiceImplTest {
    @Mock
    private FlightTicketRepository flightTicketRepository;
    @Mock
    private FlightTicketMapper flightTicketMapper;

    @InjectMocks
    private FlightTicketServiceImpl flightTicketService;

    @Test
    void getAllFlightTickets_Success() {
        Pageable pageable = PageRequest.of(0, 10);

        FlightTicket flightTicket = new FlightTicket();
        flightTicket.setName("Test FlightTicket");
        List<FlightTicket> flightTickets = Collections.singletonList(flightTicket);
        Page<FlightTicket> flightTicketPage = new PageImpl<>(flightTickets, pageable, flightTickets.size());

        FlightTicketResponseDTO flightTicketResponseDTO = new FlightTicketResponseDTO();
        flightTicketResponseDTO.setName("Test FlightTicket");
        List<FlightTicketResponseDTO> dtos = Collections.singletonList(flightTicketResponseDTO);
        Page<FlightTicketResponseDTO> dtoPage = new PageImpl<>(dtos, pageable, dtos.size());

        when(flightTicketRepository.findAll(any(Specification.class), eq(pageable))).thenReturn(flightTicketPage);
        when(flightTicketMapper.map(flightTicketPage)).thenReturn(dtoPage);

        Page<FlightTicketResponseDTO> result = flightTicketService.getAllFlightTickets("Test FlightTicket", pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals("Test FlightTicket", result.getContent().get(0).getName());
    }
    @Test
    void createFlightTicket_Success() {
        FlightTicketRequestDTO flightTicketRequestDTO=new FlightTicketRequestDTO();
        flightTicketRequestDTO.setName("Test FlightTicket");

        FlightTicket flightTicket = new FlightTicket();
        flightTicket.setName("Test FlightTicket");

        when(flightTicketMapper.toFlightTicket(flightTicketRequestDTO)).thenReturn(flightTicket);

        assertDoesNotThrow(()->flightTicketService.createFlightTicket(flightTicketRequestDTO));
        verify(flightTicketRepository, times(1)).save(flightTicket);

}
    @Test
    void getFlightTicketById_Success() {
        Long id = 1l;
        FlightTicket flightTicket = new FlightTicket();
        flightTicket.setId(id);

        FlightTicketResponseFullDTO flightTicketResponseFullDTO = new FlightTicketResponseFullDTO();
        flightTicketResponseFullDTO.setId(id);

        when(flightTicketRepository.findById(id)).thenReturn(Optional.of(flightTicket));
        when(flightTicketMapper.toFullDTO(flightTicket)).thenReturn(flightTicketResponseFullDTO);

        FlightTicketResponseFullDTO result = flightTicketService.getFlightTicketById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
}

    @Test
    void getFlightTicketById_Fail() {
        Long id = 1l;
        FlightTicket flightTicket = new FlightTicket();
        flightTicket.setId(id);

        FlightTicketResponseFullDTO flightTicketResponseFullDTO = new FlightTicketResponseFullDTO();
        flightTicketResponseFullDTO.setId(id);

        when(flightTicketRepository.findById(id)).thenReturn(Optional.empty());


        assertThrows(FlightTicketNotFoundException.class,()->flightTicketService.getFlightTicketById(id));
    }
    @Test
    void updateFlightTicket_Success() {
        FlightTicketUpdateDTO flightTicketUpdateDTO=new FlightTicketUpdateDTO();
        flightTicketUpdateDTO.setName("Test FlightTicket");

        FlightTicket flightTicket = new FlightTicket();
        flightTicket.setName("Test FlightTicket");

        when(flightTicketMapper.toFlightTicket(flightTicketUpdateDTO)).thenReturn(flightTicket);

        assertDoesNotThrow(()->flightTicketService.updateFlightTicket(flightTicketUpdateDTO));
        verify(flightTicketRepository, times(1)).save(flightTicket);

    }

    @Test
    void deleteItem_Success(){
        Long id=1L;

        doNothing().when(flightTicketRepository).deleteById(id);

        assertDoesNotThrow(()->flightTicketService.deleteFlightTicket(id));
        Mockito.verify(flightTicketRepository,times(1)).deleteById(id);
    }

    @Test
    void deleteItem_Fail(){
        Long id=1L;

        doThrow(EmptyResultDataAccessException.class).when(flightTicketRepository).deleteById(id);
        assertThrows(EmptyResultDataAccessException.class,()->flightTicketService.deleteFlightTicket(id));
    }
    }

