package ru.fomin.hotels.service.service_implements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fomin.hotels.dto.request.CreateConvenienceCategoryRequest;
import ru.fomin.hotels.dto.response.FindAllConvenienceCategoryResponse;
import ru.fomin.hotels.entity.Convenience;
import ru.fomin.hotels.entity.ConvenienceCategory;
import ru.fomin.hotels.mapper.ConvenienceCategoryMapper;
import ru.fomin.hotels.repository.ConvenienceCategoryRepository;
import ru.fomin.hotels.service.ConvenienceCategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConvenienceCategoryServiceImplements implements ConvenienceCategoryService {

    private final ConvenienceCategoryRepository repository;

    private final ConvenienceCategoryMapper mapper;

    @Override
    @Transactional
    public void createConvenienceCategory(CreateConvenienceCategoryRequest request) {
        ConvenienceCategory category = mapper.map(request);
        repository.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FindAllConvenienceCategoryResponse> findAllConvenienceCategories() {
        List<ConvenienceCategory> categories = repository.findAll();
        return mapper.map(categories);
    }

}
