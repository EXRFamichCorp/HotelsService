package ru.fomin.hotels.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fomin.hotels.dto.request.CreatHotelRequest;
import ru.fomin.hotels.dto.request.EnableAndDisableReservationsHotelRequest;
import ru.fomin.hotels.dto.request.UpdateHotelRequest;
import ru.fomin.hotels.dto.response.FindAllHotelForAdminResponse;
import ru.fomin.hotels.dto.response.FindAllHotelForUserResponse;
import ru.fomin.hotels.dto.response.FindByIdHotelResponse;
import ru.fomin.hotels.service.HotelService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
public class HotelRestController {

    private final HotelService hotelService;

    @PostMapping
    ResponseEntity<?> createHotel(@RequestBody CreatHotelRequest request){
        return ResponseEntity.ok(hotelService.createHotel(request));
    }

    @PutMapping
    ResponseEntity<?> updateHotel(@RequestBody UpdateHotelRequest request){
        hotelService.updateHotel(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findByID(@PathVariable("id") UUID id){
        FindByIdHotelResponse response = hotelService.findByID(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/admin")
    ResponseEntity<?> findAllForAdmin(){
        List<FindAllHotelForAdminResponse> response = hotelService.findAllForAdmin();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user")
    ResponseEntity<?> findAllForUser(){
        List<FindAllHotelForUserResponse> response = hotelService.findAllForUser();
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/enable")
    ResponseEntity<?> enableReservation(@RequestBody EnableAndDisableReservationsHotelRequest request){
        hotelService.enableReservation(request);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/disable")
    ResponseEntity<?> disableReservation(@RequestBody EnableAndDisableReservationsHotelRequest request){
        hotelService.disableReservation(request);
        return ResponseEntity.ok().build();
    }







}
