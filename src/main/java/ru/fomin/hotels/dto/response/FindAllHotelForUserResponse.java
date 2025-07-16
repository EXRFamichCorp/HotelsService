package ru.fomin.hotels.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAllHotelForUserResponse {

    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "stars")
    private Short stars;

    @JsonProperty(value = "latitude")
    private BigDecimal latitude;

    @JsonProperty(value = "longitude")
    private BigDecimal longitude;

}
