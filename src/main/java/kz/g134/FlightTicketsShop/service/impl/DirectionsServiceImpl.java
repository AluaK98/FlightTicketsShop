package kz.g134.FlightTicketsShop.service.impl;

import kz.g134.FlightTicketsShop.entity.Direction;
import kz.g134.FlightTicketsShop.repository.DirectionRepository;
import kz.g134.FlightTicketsShop.service.DirectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectionsServiceImpl implements DirectionsService {
    private final DirectionRepository directionRepository;

    @Override
    public List<Direction> getAll() {
        return directionRepository.findAll();
    }
}
