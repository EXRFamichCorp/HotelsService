package ru.fomin.hotels.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.fomin.hotels.dto.request.HotelCreatRequest;
import ru.fomin.hotels.dto.request.HotelUpdateRequest;
import ru.fomin.hotels.dto.response.HotelCreatResponse;
import ru.fomin.hotels.dto.response.HotelFindByIdResponse;

import java.util.UUID;

public interface HotelService {

    HotelCreatResponse createHotel(HotelCreatRequest request);

    String updateHotel(HotelUpdateRequest request);

    HotelFindByIdResponse findByID(UUID id);

    Page<HotelFindByIdResponse> findAll(Pageable pageable);

}
