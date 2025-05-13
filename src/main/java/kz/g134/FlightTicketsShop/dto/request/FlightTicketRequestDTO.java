package kz.g134.FlightTicketsShop.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class FlightTicketRequestDTO {
    @NotNull
    private String name;
    @NotNull
    private Integer uniqueNumber;
    @NotNull
    private Integer price;
    @NotNull
    private Long aircraftTypeId;
    @NotNull
    private Long classTypeId;
    @NotNull
    private Long luggageId;
    @NotNull
    private Long directionId;

}
