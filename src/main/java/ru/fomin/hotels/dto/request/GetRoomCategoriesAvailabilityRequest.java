package ru.fomin.hotels.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ru.fomin.hotels.dto.RoomDistributionDto;

import com.google.protobuf.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetRoomCategoriesAvailabilityRequest {

    @JsonProperty(value = "hotelId")
    private UUID hotelId;

    @JsonProperty(value = "checkInDay")
    private Timestamp checkInDay;

    @JsonProperty(value = "checkOutDay")
    private Timestamp checkOutDay;

    private int requiredRoomsNumber;

    @JsonProperty(value = "distributions")
    private RoomDistributionDto[] distributions;




}
