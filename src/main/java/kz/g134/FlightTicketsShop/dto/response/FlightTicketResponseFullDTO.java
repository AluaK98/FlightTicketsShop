package kz.g134.FlightTicketsShop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightTicketResponseFullDTO {
    private Long id;
    private Integer uniqueNumber;
    private String name;
    private Integer price;
    private AircraftTypeResponseDTO aircraftType;
    private ClassTypeResponseDTO classType;
    private LuggageResponseDTO luggage;
    private DirectionResponseDTO direction;
}

