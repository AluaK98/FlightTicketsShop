package kz.g134.FlightTicketsShop.mapper;

import kz.g134.FlightTicketsShop.dto.request.FlightTicketRequestDTO;
import kz.g134.FlightTicketsShop.dto.request.FlightTicketUpdateDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseDTO;
import kz.g134.FlightTicketsShop.dto.response.FlightTicketResponseFullDTO;
import kz.g134.FlightTicketsShop.entity.FlightTicket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring",
        uses = {DirectionMapper.class,
                MapperHelper.class,
                AircraftTypeMapper.class,
                ClassTypeMapper.class,
                LuggageMapper.class,

})
public interface FlightTicketMapper {
    @Mapping(target = "direction", source = "direction")
    @Mapping(target = "aircraftType", source = "aircraftType")
    @Mapping(target = "classType", source = "classType")
    @Mapping(target = "luggage", source = "luggage")
    FlightTicketResponseDTO toResponseDTO(FlightTicket flightTicket);

    default Page<FlightTicketResponseDTO> map (Page <FlightTicket> data) {
        return data.map(this::toResponseDTO);
    }

    @Mapping(target="aircraftType", source = "aircraftTypeId", qualifiedByName = "mapToAircraftType")
    @Mapping(target="classType", source = "classTypeId", qualifiedByName = "mapToClassType")
    @Mapping(target="luggage", source="luggageId", qualifiedByName = "mapToLuggage")
    @Mapping(target="direction", source="directionId", qualifiedByName = "mapToDirection")
    FlightTicket toFlightTicket(FlightTicketRequestDTO dto);

    @Mapping(target="aircraftType", source = "aircraftTypeId", qualifiedByName = "mapToAircraftType")
    @Mapping(target="classType", source = "classTypeId", qualifiedByName = "mapToClassType")
    @Mapping(target="luggage", source="luggageId", qualifiedByName = "mapToLuggage")
    @Mapping(target="direction", source="directionId", qualifiedByName = "mapToDirection")

    FlightTicket toFlightTicket(FlightTicketUpdateDTO dto);

    FlightTicketResponseFullDTO toFullDTO(FlightTicket flightTicket);


}

