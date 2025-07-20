package ru.fomin.hotels.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ru.fomin.hotels.entity.RoomCategory;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetRoomCategoriesAvailabilityResponse {

    @JsonProperty(value = "room_category")
    private RoomCategory roomCategories;

}
