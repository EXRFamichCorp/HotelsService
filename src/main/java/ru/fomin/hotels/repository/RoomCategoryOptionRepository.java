package ru.fomin.hotels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fomin.hotels.entity.RoomCategoryOption;

public interface RoomCategoryOptionRepository extends JpaRepository<RoomCategoryOption, Long> {
}
