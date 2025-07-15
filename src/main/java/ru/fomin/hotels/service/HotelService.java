package ru.fomin.hotels.service;

import ru.fomin.hotels.dto.request.HotelCreatRequest;
import ru.fomin.hotels.dto.request.HotelUpdateRequest;
import ru.fomin.hotels.dto.response.HotelCreatResponse;

public interface HotelService {

    HotelCreatResponse createHotel(HotelCreatRequest request);

    String updateHotel(HotelUpdateRequest request);

}
