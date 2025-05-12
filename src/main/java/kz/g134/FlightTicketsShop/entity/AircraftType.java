package kz.g134.FlightTicketsShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="aircraft_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AircraftType extends BaseClass {
    @Column(name="name",nullable=false)
    private String name;
}
