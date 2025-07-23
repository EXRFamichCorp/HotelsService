package ru.fomin.hotels.mapper;

import com.google.type.Decimal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.fomin.hotels.dto.response.AvailableRoomCategoryDto;
import ru.fomin.hotels.dto.response.GetRoomCategoriesAvailabilityResponse;
import ru.fomin.hotels.dto.response.NonAvailableRoomCategoryDto;
import ru.fomin.hotels.dto.response.RoomCategoryAvailabilityInfo;
import ru.fomin.hotels.entity.RoomCategory;

import java.util.List;

@Mapper
public interface RoomCategoryMapper {

    GetRoomCategoriesAvailabilityResponse map(RoomsAvailability.RoomsAvailabilityServiceOuterClass.GetRoomCategoriesAvailabilityResponse response);


    AvailableRoomCategoryDto[] mapAvailable(List<RoomCategory> categories);

    NonAvailableRoomCategoryDto[] mapNoAvailable(List<RoomCategory> categories);




}
