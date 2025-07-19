package ru.fomin.hotels.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
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
    private Integer roomCategoryId;

    @JsonProperty(value = "last_edit")
    private Instant priceLastEditedAtUtc;

}
