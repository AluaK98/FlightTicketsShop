package kz.g134.FlightTicketsShop.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForgetPasswordDTO {
    @Schema(name = "username", example = "Alua", required = true)
    @NotNull
    private String username;

    @Schema(name = "newPassword", example = "qwerty", required = true)
    @NotNull
    private String newPassword;

    @Schema(name = "reNewPassword", example = "qwerty", required = true)
    @NotNull
    private String reNewPassword;
}
