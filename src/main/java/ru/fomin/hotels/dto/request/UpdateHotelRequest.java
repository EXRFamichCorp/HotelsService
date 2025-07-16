package ru.fomin.hotels.dto.request;

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
public class UpdateHotelRequest {

    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "isAcceptReservations")
    private boolean isAcceptReservations;

    @JsonProperty(value = "stars")
    private Short stars;

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "latitude")
    private BigDecimal latitude;

    @JsonProperty(value = "longitude")
    private BigDecimal longitude;

    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "checkInTime")
    private LocalTime checkInTime;

    @JsonProperty(value = "checkOutTime")
    private LocalTime checkOutTime;

}
