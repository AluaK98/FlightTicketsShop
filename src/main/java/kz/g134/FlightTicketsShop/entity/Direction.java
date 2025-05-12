package kz.g134.FlightTicketsShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="directions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Direction extends BaseClass {
    @Column(name="name",nullable=false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="flighttickets_directions",
            joinColumns = @JoinColumn(name="direction_id"),
            inverseJoinColumns=@JoinColumn(name="flightticket_id")
    )
            private List <FlightTicket> flightTickets;

}


