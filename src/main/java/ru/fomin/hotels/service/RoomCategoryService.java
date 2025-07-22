package ru.fomin.hotels.service;

import ru.fomin.hotels.dto.request.GetAvailabilityRoomCategoryRequest;
import ru.fomin.hotels.entity.RoomCategory;

import java.util.List;

public interface RoomCategoryService {

    List<List<RoomCategory>> gettingAllAvailableRoomCategories(GetAvailabilityRoomCategoryRequest request);

}
