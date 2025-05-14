package kz.g134.FlightTicketsShop.util;

import jakarta.persistence.criteria.Predicate;
import kz.g134.FlightTicketsShop.entity.FlightTicket;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class FlightTicketSpecification {
    public Specification<FlightTicket> getItemSpecification(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }
            Predicate commonPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[0]));

            return commonPredicate;
        };
    }
}

