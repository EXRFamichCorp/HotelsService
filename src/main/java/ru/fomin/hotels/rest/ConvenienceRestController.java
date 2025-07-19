package ru.fomin.hotels.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fomin.hotels.dto.request.CreatConvenienceRequest;
import ru.fomin.hotels.dto.response.FindAllConvenienceResponse;
import ru.fomin.hotels.service.ConvenienceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/convenience")
public class ConvenienceRestController {

    private final ConvenienceService convenienceService;

    @PostMapping
    ResponseEntity<?> createConvenience(@RequestBody CreatConvenienceRequest request) {
        int id = convenienceService.createConvenience(request);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    ResponseEntity<?> findAllConvenience(){
        List<FindAllConvenienceResponse> list = convenienceService.findAllConvenience();
        return ResponseEntity.ok(list);
    }

}
