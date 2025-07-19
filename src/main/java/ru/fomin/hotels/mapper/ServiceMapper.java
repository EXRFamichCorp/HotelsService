package ru.fomin.hotels.mapper;

import org.mapstruct.Mapper;
import ru.fomin.hotels.dto.request.CreateServiceRequest;
import ru.fomin.hotels.dto.response.FindServiceResponse;
import ru.fomin.hotels.entity.Service;

import java.util.List;

@Mapper
public interface ServiceMapper {

    Service map(CreateServiceRequest request);

    FindServiceResponse map(Service service);

    List<FindServiceResponse> map(List<Service> services);

}
