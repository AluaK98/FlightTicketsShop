package kz.g134.FlightTicketsShop.repository;

import kz.g134.FlightTicketsShop.entity.AircraftType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftTypeRepository extends JpaRepository<AircraftType, Long> {

}
