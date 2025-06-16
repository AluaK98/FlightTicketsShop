package kz.g134.FlightTicketsShop.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class FlightTicketRequestDTO {
    @NotNull
    @Schema(name = "name", example = "Air Astana", required = true)
    private String name;

    @NotNull
    @Schema(name = "uniqueNumber", example = "123456", required = true)
    private Integer uniqueNumber;

    @NotNull
    @Schema(name = "price", example = "120000", required = true)
    private Integer price;

    @NotNull
    @Schema(name = "aircraftTypeId", example = "1", required = true)
    private Long aircraftTypeId;

    @NotNull
    @Schema(name = "classTypeId", example = "1", required = true)
    private Long classTypeId;

    @NotNull
    @Schema(name = "luggageId", example = "1", required = true)
    private Long luggageId;


    @NotNull
    @Schema(name = "directionId", example = "1", required = true)
    private Long directionId;

}
