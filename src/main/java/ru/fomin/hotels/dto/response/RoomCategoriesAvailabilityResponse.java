package ru.fomin.hotels.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomCategoriesAvailabilityResponse {

    private List<AvailableRoomCategoryDto> availableRoomCategories;

    private List<NonAvailableRoomCategoryDto> nonAvailableRoomCategories;

    private List<NonAvailableRoomCategoryDto> nonAccommodatedRoomCategories ;

}
