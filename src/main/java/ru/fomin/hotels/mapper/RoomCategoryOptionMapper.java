package ru.fomin.hotels.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.fomin.hotels.dto.request.CreateRoomCategoryOptionRequest;
import ru.fomin.hotels.entity.RoomCategoryOption;

@Mapper
public interface RoomCategoryOptionMapper {

    RoomCategoryOption map(CreateRoomCategoryOptionRequest request);

}
