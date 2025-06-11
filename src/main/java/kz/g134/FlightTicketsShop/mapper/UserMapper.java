package kz.g134.FlightTicketsShop.mapper;

import kz.g134.FlightTicketsShop.dto.request.UserRegisterRequestDTO;
import kz.g134.FlightTicketsShop.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserMapper {
    User toUser(UserRegisterRequestDTO registerRequest);

}
