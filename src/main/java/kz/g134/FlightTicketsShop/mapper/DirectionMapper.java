package kz.g134.FlightTicketsShop.mapper;

import kz.g134.FlightTicketsShop.dto.response.DirectionResponseDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseDTO;
import kz.g134.FlightTicketsShop.entity.Direction;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface DirectionMapper {
    DirectionResponseDTO toDTO(Direction direction);

}
