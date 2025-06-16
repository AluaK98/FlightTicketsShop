package kz.g134.FlightTicketsShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="directions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Direction extends BaseClass {
    @Column(name="name",nullable=false)
    private String name;
}


