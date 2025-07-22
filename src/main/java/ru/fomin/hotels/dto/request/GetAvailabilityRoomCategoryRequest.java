package ru.fomin.hotels.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import com.google.protobuf.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAvailabilityRoomCategoryRequest {

    @JsonProperty(value = "adultCount")
    private int adultCount;

    @JsonProperty(value = "childrenCount")
    private int childrenCount;

    @JsonProperty(value = "petsCount")
    private int petsCount;

    @JsonProperty(value = "hotelId")
    private String hotelId;

    @JsonProperty(value = "checkInDate")
    private Timestamp checkInDate;

    @JsonProperty(value = "checkOutDate")
    private Timestamp checkOutDate;

    @JsonProperty(value = "requiredRoomsNumber")
    private int requiredRoomsNumber;

}
