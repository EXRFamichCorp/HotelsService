package ru.fomin.hotels.service.service_implements;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import ru.fomin.hotels.dto.request.CreateServiceRequest;
import ru.fomin.hotels.dto.response.FindServiceResponse;
import ru.fomin.hotels.entity.Service;
import ru.fomin.hotels.mapper.ServiceMapper;
import ru.fomin.hotels.repository.ServiceRepository;
import ru.fomin.hotels.service.ServiceService;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImplements implements ServiceService {

    private final ServiceRepository serviceRepository;

    private final ServiceMapper serviceMapper;

    @Override
    @Transactional
    public void createService(CreateServiceRequest request) {
        Service service = serviceMapper.map(request);
        serviceRepository.save(service);

    }

    @Override
    @Transactional(readOnly = true)
    public List<FindServiceResponse> findAllServices() {
        List<Service> services = serviceRepository.findAll();
        return serviceMapper.map(services);
    }

}
