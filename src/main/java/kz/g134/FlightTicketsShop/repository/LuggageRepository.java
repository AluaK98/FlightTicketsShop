package kz.g134.FlightTicketsShop.repository;

import kz.g134.FlightTicketsShop.entity.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuggageRepository extends JpaRepository<Luggage, Long> {
}


