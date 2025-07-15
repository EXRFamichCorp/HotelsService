package ru.fomin.hotels.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rate_included_services")
public class RateIncludedService {

    @EmbeddedId
    private RateServiceId id;

    @ManyToOne
    @MapsId("rateId")
    @JoinColumn(name = "rate_id")
    private Rate rate;

    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(nullable = false)
    private Short discount;

    // Getters and setters
}