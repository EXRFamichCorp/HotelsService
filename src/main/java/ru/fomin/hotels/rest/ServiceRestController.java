package ru.fomin.hotels.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fomin.hotels.dto.request.CreateServiceRequest;
import ru.fomin.hotels.dto.response.FindServiceResponse;
import ru.fomin.hotels.service.ServiceService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service")
@RequiredArgsConstructor
public class ServiceRestController {

    private final ServiceService service;

    @PostMapping
    ResponseEntity<?> createService(@RequestBody CreateServiceRequest request) {
        service.createService(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<?> findAllServices(){
        List<FindServiceResponse> response = service.findAllServices();
        return ResponseEntity.ok(response);
    }

}
