package ru.fomin.hotels.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "conveniences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Convenience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private ConvenienceCategory category;

    @Column(nullable = false)
    private String title;

    @ManyToMany(mappedBy = "conveniences")
    private Set<RoomCategory> roomCategories = new HashSet<>();
}