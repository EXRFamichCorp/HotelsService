package ru.fomin.hotels.service.service_implements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fomin.hotels.dto.request.GetAvailabilityRoomCategoryRequest;
import ru.fomin.hotels.entity.RoomCategory;
import ru.fomin.hotels.repository.RoomCategoryRepository;
import ru.fomin.hotels.service.RoomCategoryService;
import ru.fomin.hotels.service.rooms_availability_service.RoomAvailabilityServiceClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomCategoryServiceImplements implements RoomCategoryService {

    private final RoomCategoryRepository roomCategoryRepository;

    private final RoomAvailabilityServiceClient client;

    @Override
    public List<List<RoomCategory>> gettingAllAvailableRoomCategories(GetAvailabilityRoomCategoryRequest request) {
        List<RoomCategory> allRoomCategories = roomCategoryRepository.findByHotelId(request.getHotelId());

        List<RoomCategory> availabilityRoomCategoriesForThisPeriod = client.getRoomCategoriesAvailability(
                        request.getHotelId(),
                        request.getCheckInDate(),
                        request.getCheckOutDate(),
                        request.getRequiredRoomsNumber())
                .getRoomCategories();

        List<RoomCategory> availableRoomCategoriesForThisPeriodAndAccommodatesAll =
                availabilityRoomCategoriesForThisPeriod.stream()
                        .filter(roomCategory ->
                                roomCategory.getAdultsMaxNumber() >= request.getAdultCount() &&
                                        roomCategory.getChildrenMaxNumber() >= request.getChildrenCount() &&
                                        roomCategory.getPetsMaxNumber() >= request.getPetsCount())
                        .toList();

        List<RoomCategory> availableRoomCategoriesForThisPeriodAndNotAccommodatesAll =
                availabilityRoomCategoriesForThisPeriod.stream()
                        .filter(roomCategory ->
                                roomCategory.getAdultsMaxNumber() < request.getAdultCount() ||
                                        roomCategory.getChildrenMaxNumber() < request.getChildrenCount() ||
                                        roomCategory.getPetsMaxNumber() < request.getPetsCount())
                        .toList();

        List<RoomCategory> notAvailabilityRoomCategories = new ArrayList<RoomCategory>(allRoomCategories);
        notAvailabilityRoomCategories.removeAll(availabilityRoomCategoriesForThisPeriod);

         return Arrays.asList(
                 availableRoomCategoriesForThisPeriodAndAccommodatesAll,
                 availableRoomCategoriesForThisPeriodAndNotAccommodatesAll,
                 notAvailabilityRoomCategories
         );


    }


}



