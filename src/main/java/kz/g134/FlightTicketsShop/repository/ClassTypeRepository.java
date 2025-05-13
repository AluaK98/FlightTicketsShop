package kz.g134.FlightTicketsShop.repository;

import kz.g134.FlightTicketsShop.entity.ClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassTypeRepository extends JpaRepository<ClassType, Long> {

}
