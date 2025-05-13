package kz.g134.FlightTicketsShop.repository;

import kz.g134.FlightTicketsShop.entity.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long> {
}

