package ru.fomin.hotels.service.service_implements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fomin.hotels.dto.request.CreateRoomCategoryOptionRequest;
import ru.fomin.hotels.entity.RoomCategory;
import ru.fomin.hotels.entity.RoomCategoryOption;
import ru.fomin.hotels.exception.NotFoundException;
import ru.fomin.hotels.mapper.RoomCategoryOptionMapper;
import ru.fomin.hotels.repository.RoomCategoryOptionRepository;
import ru.fomin.hotels.repository.RoomCategoryRepository;
import ru.fomin.hotels.service.RoomCategoryOptionService;

@Service
@RequiredArgsConstructor
public class RoomCategoryOptionServiceImplements implements RoomCategoryOptionService {

    private final RoomCategoryOptionRepository roomCategoryOptionRepository;

    private final RoomCategoryOptionMapper roomCategoryOptionMapper;

    private final RoomCategoryRepository roomCategoryRepository;

    @Override
    @Transactional
    public void createRoomCategoryOption(CreateRoomCategoryOptionRequest request) {
        RoomCategory roomCategory = roomCategoryRepository.findById(Long.valueOf(request.getRoomCategoryId()))
                .orElseThrow(() -> new NotFoundException("RoomCategory not found"));
        RoomCategoryOption roomCategoryOption = roomCategoryOptionMapper.map(request);
        roomCategoryOption.setRoomCategory(roomCategory);
        roomCategoryOptionRepository.save(roomCategoryOption);
    }

}
