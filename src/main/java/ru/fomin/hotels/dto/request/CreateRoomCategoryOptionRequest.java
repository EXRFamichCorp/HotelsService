package ru.fomin.hotels.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ru.fomin.hotels.entity.RoomCategory;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomCategoryOptionRequest {

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "room_category")
    private RoomCategory roomCategory;

    @JsonProperty(value = "last_edit")
    private Instant priceLastEditedAtUtc;

}
