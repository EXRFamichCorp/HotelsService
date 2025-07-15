package ru.fomin.hotels.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.fomin.hotels.dto.request.HotelCreatRequest;
import ru.fomin.hotels.dto.request.HotelUpdateRequest;
import ru.fomin.hotels.dto.response.HotelCreatResponse;
import ru.fomin.hotels.entity.Hotel;

@Mapper
public interface HotelMapper {

    Hotel mapToHotel(HotelCreatRequest request);

    HotelCreatResponse mapToResponse(Hotel hotel);

    Hotel mapUpdate(HotelUpdateRequest userUpdateRequest, @MappingTarget Hotel hotel);
}
