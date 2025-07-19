package ru.fomin.hotels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fomin.hotels.entity.ConvenienceCategory;

public interface ConvenienceCategoryRepository extends JpaRepository<ConvenienceCategory, Long> {
}
