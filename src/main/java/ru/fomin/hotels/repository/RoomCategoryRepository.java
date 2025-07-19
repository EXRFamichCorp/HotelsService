package ru.fomin.hotels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fomin.hotels.entity.RoomCategory;

public interface RoomCategoryRepository extends JpaRepository<RoomCategory, Long> {
}
