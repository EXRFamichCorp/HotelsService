package ru.fomin.hotels.rest;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fomin.hotels.dto.request.HotelCreatRequest;
import ru.fomin.hotels.dto.request.HotelUpdateRequest;
import ru.fomin.hotels.dto.response.HotelCreatResponse;
import ru.fomin.hotels.dto.response.HotelFindByIdResponse;
import ru.fomin.hotels.service.HotelService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
public class HotelRestController {

    private final HotelService hotelService;

    @PostMapping
    ResponseEntity<?> createHotel(@RequestBody HotelCreatRequest request){
        HotelCreatResponse response = hotelService.createHotel(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    ResponseEntity<?> updateHotel(@RequestBody HotelUpdateRequest request){
        String response = hotelService.updateHotel(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findByID(@PathVariable("id") UUID id){
        HotelFindByIdResponse response = hotelService.findByID(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    ResponseEntity<?> findAll(Pageable pageable){
        Page<HotelFindByIdResponse> response = hotelService.findAll(pageable);
        return ResponseEntity.ok(response);
    }

}
