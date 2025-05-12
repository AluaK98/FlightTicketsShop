package kz.g134.FlightTicketsShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="class_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ClassType extends BaseClass {
    @Column(name="name",nullable=false)
    private String name;
}


