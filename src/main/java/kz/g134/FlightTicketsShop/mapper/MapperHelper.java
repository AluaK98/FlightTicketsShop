package kz.g134.FlightTicketsShop.mapper;

import kz.g134.FlightTicketsShop.entity.AircraftType;
import kz.g134.FlightTicketsShop.entity.ClassType;
import kz.g134.FlightTicketsShop.entity.Direction;
import kz.g134.FlightTicketsShop.entity.Luggage;
import kz.g134.FlightTicketsShop.exception.AircraftTypeNotFoundException;
import kz.g134.FlightTicketsShop.exception.ClassTypeNotFoundException;
import kz.g134.FlightTicketsShop.exception.DirectionNotFoundException;
import kz.g134.FlightTicketsShop.exception.LuggageNotFoundException;
import kz.g134.FlightTicketsShop.repository.AircraftTypeRepository;
import kz.g134.FlightTicketsShop.repository.ClassTypeRepository;
import kz.g134.FlightTicketsShop.repository.DirectionRepository;
import kz.g134.FlightTicketsShop.repository.LuggageRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperHelper {
    private final AircraftTypeRepository aircraftTypeRepository;
    private final ClassTypeRepository classTypeRepository;
    private final LuggageRepository luggageRepository;
    private final DirectionRepository directionRepository;

    @Named("mapToAircraftType")
    public AircraftType findByIdAircraftType(Long id){
        return aircraftTypeRepository.findById(id).orElseThrow(()-> new AircraftTypeNotFoundException("Aircraft type not found"));
    }

    @Named("mapToClassType")
    public ClassType findByIdClassType(Long id) {
        return classTypeRepository.findById(id).orElseThrow(() -> new ClassTypeNotFoundException("Class type not found"));
    }
    @Named("mapToLuggage")
    public Luggage findByIdLuggage(Long id){
        return luggageRepository.findById(id).orElseThrow(()->new LuggageNotFoundException("Luggage not found"));
    }
    @Named("mapToDirection")
    public Direction findByIdDirection(Long id){
        return directionRepository.findById(id).orElseThrow(()->new DirectionNotFoundException("Direction not found"));
    }

    }

