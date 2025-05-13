package kz.g134.FlightTicketsShop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="luggages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Luggage extends BaseClass {
    @Column(name="name",nullable=false)
    private String name;
}
