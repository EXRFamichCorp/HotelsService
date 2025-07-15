package ru.fomin.hotels.service.service_implements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fomin.hotels.dto.request.HotelCreatRequest;
import ru.fomin.hotels.dto.request.HotelUpdateRequest;
import ru.fomin.hotels.dto.response.HotelCreatResponse;
import ru.fomin.hotels.entity.Hotel;
import ru.fomin.hotels.exception.NotFoundException;
import ru.fomin.hotels.mapper.HotelMapper;
import ru.fomin.hotels.repository.HotelRepository;
import ru.fomin.hotels.service.HotelService;

@Service
@RequiredArgsConstructor
public class HotelServiceImplements implements HotelService {

    private final HotelRepository hotelRepository;

    private final HotelMapper hotelMapper;

    @Override
    @Transactional
    public HotelCreatResponse createHotel(HotelCreatRequest request) {
        return hotelMapper.mapToResponse(hotelRepository.save(hotelMapper.mapToHotel(request)));
    }

    @Override
    @Transactional
    public String updateHotel(HotelUpdateRequest request) {
        Hotel hotel = hotelRepository.findById(request.getId())
                .orElseThrow(()->new NotFoundException("hotel.notFound"));
        Hotel hotelResponse = hotelMapper.mapUpdate(request,hotel);
        hotelRepository.save(hotelResponse);
        return "The hotel information has been changed";
    }

}
