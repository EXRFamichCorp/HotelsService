package ru.fomin.hotels.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ru.fomin.hotels.entity.RoomCategory;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetRoomCategoriesAvailabilityResponse {

    @JsonProperty(value = "room_category")
    private List<RoomCategory> roomCategories;

}
