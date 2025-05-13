package kz.g134.FlightTicketsShop.mapper;

import kz.g134.FlightTicketsShop.dto.response.ClassTypeResponseDTO;
import kz.g134.FlightTicketsShop.entity.ClassType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassTypeMapper {
    ClassTypeResponseDTO toDTO(ClassType classType);
}
