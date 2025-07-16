package ru.fomin.hotels.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.fomin.hotels.dto.request.CreatHotelRequest;
import ru.fomin.hotels.dto.request.UpdateHotelRequest;
import ru.fomin.hotels.dto.response.FindAllHotelForAdminResponse;
import ru.fomin.hotels.dto.response.FindAllHotelForUserResponse;
import ru.fomin.hotels.dto.response.FindByIdHotelResponse;
import ru.fomin.hotels.entity.Hotel;

import java.util.List;

@Mapper
public interface HotelMapper {

    Hotel mapToHotel(CreatHotelRequest request);

    FindByIdHotelResponse mapToFindResponse(Hotel hotel);

    Hotel mapUpdate(UpdateHotelRequest userUpdateRequest, @MappingTarget Hotel hotel);

    List<FindAllHotelForAdminResponse> mapAllForAdmin(List<Hotel> hotels);

    List<FindAllHotelForUserResponse> mapAllForUser(List<Hotel> hotels);
}
