package kz.g134.FlightTicketsShop.mapper;

import kz.g134.FlightTicketsShop.dto.response.AircraftTypeResponseDTO;
import kz.g134.FlightTicketsShop.entity.AircraftType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AircraftTypeMapper {
    AircraftTypeResponseDTO toDTO(AircraftType aircraftType);
}
