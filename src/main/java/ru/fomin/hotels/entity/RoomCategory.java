package ru.fomin.hotels.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room_categories")
public class RoomCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(length = 500)
    private String description;

    @ManyToMany
    @JoinTable(
        name = "room_category_conveniences",
        joinColumns = @JoinColumn(name = "room_category_id"),
        inverseJoinColumns = @JoinColumn(name = "convenience_id")
    )
    private Set<Convenience> conveniences;

    @OneToMany(mappedBy = "roomCategory")
    private Set<RoomCategoryOption> options;

    @OneToMany(mappedBy = "roomCategory")
    private Set<Rate> rates;

    @Column(name = "adults_max_number", nullable = false)
    private Short adultsMaxNumber;

    @Column(name = "children_max_number", nullable = false)
    private Short childrenMaxNumber;

    @Column(name = "pets_max_number", nullable = false)
    private Short petsMaxNumber;

}