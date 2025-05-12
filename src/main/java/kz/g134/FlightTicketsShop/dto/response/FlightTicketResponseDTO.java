package kz.g134.FlightTicketsShop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightTicketResponseDTO {
    private Long id;
    private String name;
    private Integer price;
    private Long aircraftTypeId;
    private Long classId;
    private List<DirectionResponseDTO> direction;
}