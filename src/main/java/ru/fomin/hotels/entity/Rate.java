package ru.fomin.hotels.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rates")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "room_category_id", nullable = false)
    private RoomCategory roomCategory;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(length = 500)
    private String description;

    @Column(name = "prepayment_in_percents", nullable = false)
    private Short prepaymentInPercents;

    @Column(name = "min_nights_count", nullable = false)
    private Short minNightsCount;

    @Column(name = "max_nights_count", nullable = false)
    private Short maxNightsCount;

    @Column(name = "adults_max_number", nullable = false)
    private Short adultsMaxNumber;

    @Column(name = "children_max_number", nullable = false)
    private Short childrenMaxNumber;

    @Column(name = "pets_max_number", nullable = false)
    private Short petsMaxNumber;

    @OneToMany(mappedBy = "rate")
    private Set<RateIncludedService> includedServices;

}