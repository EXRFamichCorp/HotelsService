package ru.fomin.hotels.service;

import ru.fomin.hotels.dto.request.GetRoomCategoriesAvailabilityRequest;
import ru.fomin.hotels.dto.response.RoomCategoriesAvailabilityResponse;
import ru.fomin.hotels.entity.RoomCategory;

import java.util.List;

public interface RoomCategoryService {

    RoomCategoriesAvailabilityResponse gettingAllAvailableRoomCategories(GetRoomCategoriesAvailabilityRequest request);

}
