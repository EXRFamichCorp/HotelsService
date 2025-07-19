package ru.fomin.hotels.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fomin.hotels.dto.request.CreateConvenienceCategoryRequest;
import ru.fomin.hotels.dto.response.FindAllConvenienceCategoryResponse;
import ru.fomin.hotels.service.ConvenienceCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/convenience-category")
@RequiredArgsConstructor
public class ConvenienceCategoryRestController {

    private final ConvenienceCategoryService convenienceCategoryService;

    @PostMapping
    ResponseEntity<?> createConvenienceCategory(@RequestBody CreateConvenienceCategoryRequest request){
        convenienceCategoryService.createConvenienceCategory(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<?> findAllConvenienceCategories(){
        List<FindAllConvenienceCategoryResponse> categoryResponses = convenienceCategoryService.findAllConvenienceCategories();
        return ResponseEntity.ok(categoryResponses);
    }

}
