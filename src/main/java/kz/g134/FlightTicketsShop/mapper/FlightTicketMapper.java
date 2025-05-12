package kz.g134.FlightTicketsShop.mapper;

import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseDTO;
import kz.g134.FlightTicketsShop.entity.FlightTicket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DirectionMapper.class})
public interface FlightTicketMapper {
    @Mapping(target = "direction", source = "directions")

    FlightTicketResponseDTO toResponseDTO(FlightTicket flightTicket);
}


