package ru.fomin.hotels.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RateIncludedServiceId implements Serializable {
    @Column(name = "rate_id")
    private Integer rateId;

    @Column(name = "service_id")
    private Integer serviceId;
}