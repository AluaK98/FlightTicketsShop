package kz.g134.FlightTicketsShop.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequestDTO {
    @Schema(name = "username", example = "Sasha", required = true)
    @NotNull
    private String username;

    @Schema(name = "fullName", example = "Sasha Loginov", required = true)
    @NotNull
    private String fullName;

    @Schema(name = "age", example = "25", required = true)
    private Integer age;

    @Schema(name = "password", example = "qwerty", required = true)
    @NotNull
    private String password;

    @Schema(name = "rePassword", example = "qwerty", required = true)
    @NotNull
    private String rePassword;
}
