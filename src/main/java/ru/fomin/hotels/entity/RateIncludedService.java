package ru.fomin.hotels.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rate_included_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateIncludedService {
    @EmbeddedId
    private RateIncludedServiceId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("rateId")
    @JoinColumn(name = "rate_id")
    private Rate rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(nullable = false)
    private Short discount;
}