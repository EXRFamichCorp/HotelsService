package ru.fomin.hotels.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 75)
    private String title;

    @Column(length = 750)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "price_last_edited_at_utc", nullable = false)
    @UpdateTimestamp
    private Instant priceLastEditedAtUtc;

    @ManyToMany(mappedBy = "includedServices")
    private Set<Rate> rates = new HashSet<>();
}