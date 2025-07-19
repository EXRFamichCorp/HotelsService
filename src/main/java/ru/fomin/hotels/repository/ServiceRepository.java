package ru.fomin.hotels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fomin.hotels.entity.Service;


public interface ServiceRepository extends JpaRepository<Service, Long> {
}
