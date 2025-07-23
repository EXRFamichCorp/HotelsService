package ru.fomin.hotels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.fomin.hotels.entity.RoomCategory;

import java.util.List;
import java.util.UUID;

public interface RoomCategoryRepository extends JpaRepository<RoomCategory, Long> {

    @Query(value = "select * from room_categories where hotel_id=:hotelId", nativeQuery = true)
    List<RoomCategory> findByHotelId(@Param("id") UUID hotelId);

}
