package kz.g134.FlightTicketsShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.util.List;

@Entity
@Table(name="flight_tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightTicket extends BaseClass {
    @Column(name="name",nullable=false)
    private String name;

    @Column(name="price")
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="aircraft_type_id", nullable=false)
    private AircraftType aircraftType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="class_id")
    private ClassType classType;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
               name="flighttickets_directions",
               joinColumns = @JoinColumn(name="flightticket_id"),
               inverseJoinColumns = @JoinColumn(name="direction_id")
    )
    private List<Direction> directions;

}
