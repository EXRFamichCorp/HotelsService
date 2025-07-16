package ru.fomin.hotels.service;

import ru.fomin.hotels.dto.request.CreatHotelRequest;
import ru.fomin.hotels.dto.request.EnableAndDisableReservationsHotelRequest;
import ru.fomin.hotels.dto.request.UpdateHotelRequest;
import ru.fomin.hotels.dto.response.FindAllHotelForAdminResponse;
import ru.fomin.hotels.dto.response.FindAllHotelForUserResponse;
import ru.fomin.hotels.dto.response.FindByIdHotelResponse;

import java.util.List;
import java.util.UUID;

public interface HotelService {

    UUID createHotel(CreatHotelRequest request);

    void updateHotel(UpdateHotelRequest request);

    FindByIdHotelResponse findByID(UUID id);

    List<FindAllHotelForAdminResponse> findAllForAdmin();

    List<FindAllHotelForUserResponse> findAllForUser();

    void enableReservation(EnableAndDisableReservationsHotelRequest request);

    void disableReservation(EnableAndDisableReservationsHotelRequest request);
}
