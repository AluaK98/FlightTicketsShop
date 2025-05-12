package kz.g134.FlightTicketsShop.repository;

import kz.g134.FlightTicketsShop.entity.FlightTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightTicketRepository extends JpaRepository<FlightTicket, Long> {
    Page<FlightTicket> findAll(Specification<FlightTicket> specification, Pageable pageable);

}
