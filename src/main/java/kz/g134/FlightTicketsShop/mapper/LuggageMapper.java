package kz.g134.FlightTicketsShop.mapper;


import kz.g134.FlightTicketsShop.dto.response.LuggageResponseDTO;
import kz.g134.FlightTicketsShop.entity.Luggage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LuggageMapper {
    LuggageResponseDTO toDTO(Luggage luggage);
}
