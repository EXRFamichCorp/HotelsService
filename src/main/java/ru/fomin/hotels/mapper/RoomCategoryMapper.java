package ru.fomin.hotels.mapper;

import org.mapstruct.Mapper;
import ru.fomin.hotels.dto.response.GetRoomCategoriesAvailabilityResponse;

@Mapper
public interface RoomCategoryMapper {

    GetRoomCategoriesAvailabilityResponse map(RoomsAvailability.RoomsAvailabilityServiceOuterClass.GetRoomCategoriesAvailabilityResponse response);

}
