package ru.fomin.hotels.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDistributionDto {

    @JsonProperty(value = "adults")
    private int adultsNumber;

    @JsonProperty(value = "children")
    private int childrenNumber;

    @JsonProperty(value = "pest")
    private int petsNumber;

}

