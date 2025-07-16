package ru.fomin.hotels.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnableAndDisableReservationsHotelRequest {

    @JsonProperty(value = "id")
    private UUID id;

}
