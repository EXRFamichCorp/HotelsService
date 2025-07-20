package ru.fomin.hotels.rooms_availability_service;

import RoomsAvailability.RoomsAvailabilityServiceOuterClass;
import com.google.protobuf.Timestamp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fomin.hotels.dto.response.GetRoomCategoriesAvailabilityResponse;
import ru.fomin.hotels.mapper.RoomCategoryMapper;

@Service
@RequiredArgsConstructor
public class RoomAvailabilityServiceClient {

    private final RoomsAvailability.RoomsAvailabilityServiceGrpc.RoomsAvailabilityServiceBlockingStub stub;

    private final RoomCategoryMapper roomCategoryMapper;

    protected GetRoomCategoriesAvailabilityResponse getRoomCategoriesAvailability(
            String hotelId,
            Timestamp checkInDate,
            Timestamp checkOutDate,
            int requiredRoomsNumber
    ) {
        RoomsAvailabilityServiceOuterClass.GetRoomCategoriesAvailabilityRequest request = RoomsAvailabilityServiceOuterClass.GetRoomCategoriesAvailabilityRequest
                .newBuilder()
                .setHotelId(hotelId)
                .setCheckInDate(checkInDate)
                .setCheckOutDate(checkOutDate)
                .setRequiredRoomsNumber(requiredRoomsNumber)
                .build();

        RoomsAvailabilityServiceOuterClass.GetRoomCategoriesAvailabilityResponse response = stub.getRoomCategoriesAvailability(request);
        return roomCategoryMapper.map(response);
    }
}
