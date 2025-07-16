package ru.fomin.hotels.service.service_implements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fomin.hotels.dto.request.CreatHotelRequest;
import ru.fomin.hotels.dto.request.EnableAndDisableReservationsHotelRequest;
import ru.fomin.hotels.dto.request.UpdateHotelRequest;
import ru.fomin.hotels.dto.response.FindAllHotelForAdminResponse;
import ru.fomin.hotels.dto.response.FindAllHotelForUserResponse;
import ru.fomin.hotels.dto.response.FindByIdHotelResponse;
import ru.fomin.hotels.entity.Hotel;
import ru.fomin.hotels.exception.NotFoundException;
import ru.fomin.hotels.mapper.HotelMapper;
import ru.fomin.hotels.repository.HotelRepository;
import ru.fomin.hotels.service.HotelService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImplements implements HotelService {

    private final HotelRepository hotelRepository;

    private final HotelMapper hotelMapper;

    @Override
    @Transactional
    public UUID createHotel(CreatHotelRequest request) {
        Hotel hotel = hotelMapper.mapToHotel(request);
        hotel.setAcceptReservations(false);
        return (hotelRepository.save(hotel)).getId();
    }

    @Override
    @Transactional
    public void updateHotel(UpdateHotelRequest request) {
        Hotel hotel = hotelRepository.findById(request.getId())
                .orElseThrow(()->new NotFoundException("hotel.notFound"));
        Hotel hotelResponse = hotelMapper.mapUpdate(request,hotel);
        hotelRepository.save(hotelResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public FindByIdHotelResponse findByID(UUID id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(()->new NotFoundException("hotel.notFound"));
        return hotelMapper.mapToFindResponse(hotel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FindAllHotelForAdminResponse> findAllForAdmin() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotelMapper.mapAllForAdmin(hotels);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FindAllHotelForUserResponse> findAllForUser() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotelMapper.mapAllForUser(hotels);
    }

    @Override
    @Transactional
    public void enableReservation(EnableAndDisableReservationsHotelRequest request) {
        Hotel hotel = hotelRepository.findById(request.getId())
                .orElseThrow(()->new NotFoundException("hotel.notFound"));
        hotel.setAcceptReservations(true);
        hotelRepository.save(hotel);
    }

    @Override
    @Transactional
    public void disableReservation(EnableAndDisableReservationsHotelRequest request) {
        Hotel hotel = hotelRepository.findById(request.getId())
                .orElseThrow(()->new NotFoundException("hotel.notFound"));
        hotel.setAcceptReservations(false);
        hotelRepository.save(hotel);
    }

}
