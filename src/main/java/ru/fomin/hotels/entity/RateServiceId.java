package ru.fomin.hotels.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
class RateServiceId implements Serializable {

    private Integer rateId;

    private Integer serviceId;

}