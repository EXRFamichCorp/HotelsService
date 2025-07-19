package ru.fomin.hotels.mapper;

import org.mapstruct.Mapper;
import ru.fomin.hotels.dto.request.ConvenienceCategoryRequest;
import ru.fomin.hotels.dto.request.CreateConvenienceCategoryRequest;
import ru.fomin.hotels.dto.response.FindAllConvenienceCategoryResponse;
import ru.fomin.hotels.dto.response.FindAllConvenienceResponse;
import ru.fomin.hotels.entity.Convenience;
import ru.fomin.hotels.entity.ConvenienceCategory;

import java.util.List;

@Mapper
public interface ConvenienceCategoryMapper {

    ConvenienceCategoryRequest map(ConvenienceCategory category);

    ConvenienceCategory map(CreateConvenienceCategoryRequest request);

    List<FindAllConvenienceCategoryResponse> map(List<ConvenienceCategory> convenienceCategories);

}
