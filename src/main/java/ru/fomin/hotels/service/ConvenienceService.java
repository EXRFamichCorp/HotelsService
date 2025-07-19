package ru.fomin.hotels.service;

import ru.fomin.hotels.dto.request.CreatConvenienceRequest;
import ru.fomin.hotels.dto.response.FindAllConvenienceResponse;

import java.util.List;

public interface ConvenienceService {

    int createConvenience(CreatConvenienceRequest request);

    List<FindAllConvenienceResponse> findAllConvenience();



}
