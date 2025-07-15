package ru.fomin.hotels.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "room_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(length = 500)
    private String description;

    @Column(name = "rooms_count", nullable = false)
    private Integer roomsCount;

    @ManyToMany
    @JoinTable(
        name = "room_category_conveniences",
        joinColumns = @JoinColumn(name = "room_category_id"),
        inverseJoinColumns = @JoinColumn(name = "convenience_id")
    )
    private Set<Convenience> conveniences = new HashSet<>();

    @OneToMany(mappedBy = "roomCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomCategoryOption> options = new ArrayList<>();

    @OneToMany(mappedBy = "roomCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rate> rates = new ArrayList<>();
}