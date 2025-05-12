package kz.g134.FlightTicketsShop.service;

import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseDTO;
import kz.g134.FlightTicketsShop.entity.FlightTicket;
import kz.g134.FlightTicketsShop.mapper.FlightTicketMapper;
import kz.g134.FlightTicketsShop.repository.FlightTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightTicketServiceImpl implements FlightTicketService {

    private final FlightTicketRepository flightTicketRepository;
    private final FlightTicketMapper flightTicketMapper;

    @Override
    public List<FlightTicketResponseDTO> getAllFlightTickets() {
        List<FlightTicketResponseDTO> result = new ArrayList<>();
        List<FlightTicket> flightTickets = flightTicketRepository.findAll();
        for (FlightTicket flightTicket : flightTickets) {
            result.add(flightTicketMapper.toResponseDTO(flightTicket));
        }
        return result;
    }
}

//    private List<FlightTicketResponseDTO> toDTO(List<FlightTicket> flightTickets) {
//        List<FlightTicketResponseDTO> flightTicketResponseDTOs = new ArrayList<>();
//        for (FlightTicket flightTicket : flightTickets) {
//            FlightTicketResponseDTO flightTicketResponseDTO = new FlightTicketResponseDTO(
//                    flightTicket.getId(),
//                    flightTicket.getName(),
//                    flightTicket.getPrice(),
//                    null,
//                    null,
//                    null,
//                    null
//            );
//            flightTicketResponseDTOs.add(flightTicketResponseDTO);
//        }
//        return flightTicketResponseDTOs;
//    }
//}
