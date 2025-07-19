package ru.fomin.hotels.service;

import ru.fomin.hotels.dto.request.CreateServiceRequest;
import ru.fomin.hotels.dto.response.FindServiceResponse;

import java.util.List;

public interface ServiceService {

    public void createService(CreateServiceRequest request);

    public List<FindServiceResponse> findAllServices();

}
