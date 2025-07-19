package ru.fomin.hotels.service.service_implements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fomin.hotels.dto.request.CreatConvenienceRequest;
import ru.fomin.hotels.dto.response.FindAllConvenienceResponse;
import ru.fomin.hotels.entity.Convenience;
import ru.fomin.hotels.entity.ConvenienceCategory;
import ru.fomin.hotels.exception.NotFoundException;
import ru.fomin.hotels.mapper.ConvenienceCategoryMapper;
import ru.fomin.hotels.mapper.ConvenienceMapper;
import ru.fomin.hotels.repository.ConvenienceCategoryRepository;
import ru.fomin.hotels.repository.ConvenienceRepository;
import ru.fomin.hotels.service.ConvenienceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConvenienceServiceImplements implements ConvenienceService {

    private final ConvenienceMapper convenienceMapper;

    private final ConvenienceCategoryMapper convenienceCategoryMapper;

    private final ConvenienceCategoryRepository convenienceCategoryRepository;

    private final ConvenienceRepository convenienceRepository;

    @Override
    @Transactional
    public int createConvenience(CreatConvenienceRequest request) {
        ConvenienceCategory category = convenienceCategoryRepository.findById(Long.valueOf(request.getCategory().getId()))
                .orElseThrow(()-> new NotFoundException("convenience category not found"));
        request.setCategory(convenienceCategoryMapper.map(category));
        Convenience convenience = convenienceMapper.map(request);
        convenienceRepository.save(convenience);
        return convenience.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<FindAllConvenienceResponse> findAllConvenience() {
        List<Convenience> conveniences = convenienceRepository.findAll();
        return convenienceMapper.map(conveniences);
    }


}
