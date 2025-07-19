package ru.fomin.hotels.mapper;

import org.mapstruct.Mapper;
import ru.fomin.hotels.dto.request.CreatConvenienceRequest;
import ru.fomin.hotels.dto.response.FindAllConvenienceResponse;
import ru.fomin.hotels.entity.Convenience;

import java.util.List;

@Mapper
public interface ConvenienceMapper {

    Convenience map(CreatConvenienceRequest request);

    List<FindAllConvenienceResponse> map(List<Convenience> convenience);

}
