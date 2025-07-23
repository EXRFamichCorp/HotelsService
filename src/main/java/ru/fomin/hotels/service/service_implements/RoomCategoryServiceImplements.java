package ru.fomin.hotels.service.service_implements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fomin.hotels.dto.RoomDistributionDto;
import ru.fomin.hotels.dto.request.GetRoomCategoriesAvailabilityRequest;
import ru.fomin.hotels.dto.response.AvailableRoomCategoryDto;
import ru.fomin.hotels.dto.response.NonAvailableRoomCategoryDto;
import ru.fomin.hotels.dto.response.RoomCategoriesAvailabilityResponse;
import ru.fomin.hotels.dto.response.RoomCategoryAvailabilityInfo;
import ru.fomin.hotels.entity.RoomCategory;
import ru.fomin.hotels.mapper.RoomCategoryMapper;
import ru.fomin.hotels.repository.RoomCategoryRepository;
import ru.fomin.hotels.service.RoomCategoryService;
import ru.fomin.hotels.service.rooms_availability_service.RoomAvailabilityServiceClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomCategoryServiceImplements implements RoomCategoryService {

    private final RoomCategoryRepository roomCategoryRepository;

    private final RoomCategoryMapper roomCategoryMapper;

    private final RoomAvailabilityServiceClient client;

    private boolean canAccommodateDistribution(RoomCategory category, RoomDistributionDto[] distributions) {
        return Arrays.stream(distributions)
                .allMatch(dist ->
                        category.getAdultsMaxNumber() >= dist.getAdultsNumber() &&
                                category.getChildrenMaxNumber() >= dist.getChildrenNumber() &&
                                category.getPetsMaxNumber() >= dist.getPetsNumber());
    }

    @Override
    public RoomCategoriesAvailabilityResponse gettingAllAvailableRoomCategories(GetRoomCategoriesAvailabilityRequest request) {
        List<RoomCategory> allRoomCategoriesByHotelId = roomCategoryRepository
                .findByHotelId(request.getHotelId());
        List<RoomCategoryAvailabilityInfo> availabilityInfo = client.getRoomCategoriesAvailability(
                request.getHotelId().toString(),
                request.getCheckInDay(),
                request.getCheckOutDay(),
                request.getRequiredRoomsNumber()
        ).getRoomCategoriesInfo();

        Map<Integer, RoomCategory> categoryMap = allRoomCategoriesByHotelId.stream()
                .collect(Collectors.toMap(RoomCategory::getId, Function.identity()));

        Map<Integer, RoomCategoryAvailabilityInfo> availabilityMap = availabilityInfo.stream()
                .collect(Collectors.toMap(RoomCategoryAvailabilityInfo::getId, Function.identity()));

        List<AvailableRoomCategoryDto> available = new ArrayList<>();
        List<NonAvailableRoomCategoryDto> nonAccommodated = new ArrayList<>();
        List<NonAvailableRoomCategoryDto> nonAvailable = new ArrayList<>();

        for (RoomCategory category : allRoomCategoriesByHotelId) {
            RoomCategoryAvailabilityInfo info = availabilityMap.get(category.getId());

            if (info == null) {
                NonAvailableRoomCategoryDto dto = NonAvailableRoomCategoryDto.builder()
                        .id(category.getId())
                        .title(category.getTitle())
                        .build();
                nonAvailable.add(dto);
                continue;
            }

            boolean canAccommodate = canAccommodateDistribution(category, request.getDistributions());

            if (canAccommodate) {
                AvailableRoomCategoryDto dto = AvailableRoomCategoryDto.builder()
                        .id(category.getId())
                        .title(category.getTitle())
                        .averagePriceForPeriod(info.getAveragePriceForPeriod())
                        .minimalRoomsNumber(info.getMinAvailableRoomsNumber())
                        .build();
                available.add(dto);
            } else {
                NonAvailableRoomCategoryDto dto = NonAvailableRoomCategoryDto.builder()
                        .id(category.getId())
                        .title(category.getTitle())
                        .build();
                nonAccommodated.add(dto);
            }
        }

        return RoomCategoriesAvailabilityResponse.builder()
                .availableRoomCategories(available)
                .nonAccommodatedRoomCategories(nonAccommodated)
                .nonAvailableRoomCategories(nonAvailable)
                .build();
    }
}



