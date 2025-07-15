package ru.fomin.hotels.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.fomin.hotels.dto.request.HotelCreatRequest;
import ru.fomin.hotels.dto.request.HotelUpdateRequest;
import ru.fomin.hotels.dto.response.HotelCreatResponse;
import ru.fomin.hotels.dto.response.HotelFindByIdResponse;
import ru.fomin.hotels.entity.Hotel;

import java.util.List;

@Mapper
public interface HotelMapper {

    Hotel mapToHotel(HotelCreatRequest request);

    HotelCreatResponse mapToCreateResponse(Hotel hotel);

    HotelFindByIdResponse mapToFindResponse(Hotel hotel);

    Hotel mapUpdate(HotelUpdateRequest userUpdateRequest, @MappingTarget Hotel hotel);
}
