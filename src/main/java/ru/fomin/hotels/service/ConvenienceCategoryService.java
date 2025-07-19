package ru.fomin.hotels.service;

import ru.fomin.hotels.dto.request.CreateConvenienceCategoryRequest;
import ru.fomin.hotels.dto.response.FindAllConvenienceCategoryResponse;
import ru.fomin.hotels.entity.ConvenienceCategory;

import java.util.List;

public interface ConvenienceCategoryService {

    void createConvenienceCategory(CreateConvenienceCategoryRequest request);

    List<FindAllConvenienceCategoryResponse> findAllConvenienceCategories();

}
