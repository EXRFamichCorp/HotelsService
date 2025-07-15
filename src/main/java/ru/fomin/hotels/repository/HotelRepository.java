package ru.fomin.hotels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fomin.hotels.entity.Hotel;

import java.util.Optional;
import java.util.UUID;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Optional<Hotel> findById(UUID id);

    void deleteById(UUID id);

}
