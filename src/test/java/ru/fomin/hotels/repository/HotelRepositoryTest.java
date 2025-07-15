package ru.fomin.hotels.repository;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.fomin.hotels.entity.Hotel;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@DataJpaTest
public class HotelRepositoryTest {

    @Autowired
    private HotelRepository hotelRepository;

    @BeforeEach
    public void setUp() throws Exception {
        hotelRepository.deleteAll();
    }

    @Test
    @DisplayName("Create hotel test")
    public void givenHotelToSave_whenSaveHotel_thenHotelIsSaved(){
        //given
        Hotel hotel = Hotel.builder()
                .title("Grand Hotel")
                .description("Прекрасный отель с видом на море, расположенный в центре города. Идеальное место для отдыха и бизнес-поездок.")
                .isAcceptReservations(true)
                .stars((short) 5)
                .city("Санкт-Петербург")
                .address("Невский проспект, 1")
                .latitude(new BigDecimal("59.9358000"))
                .longitude(new BigDecimal("30.3256000"))
                .phoneNumber("+7 (812) 123-45-67")
                .email("info@grandhotel.ru")
                .checkInTime(LocalTime.of(14, 0))
                .checkOutTime(LocalTime.of(12, 0))
                .build();
        //when
        Hotel hotelSaved = hotelRepository.save(hotel);
        //then
        Assertions.assertNotNull(hotelSaved.getId());
        Assertions.assertNotNull(hotelSaved.getTitle());
        Assertions.assertNotNull(hotelSaved.getDescription());
        Assertions.assertNotNull(hotelSaved.isAcceptReservations());
        Assertions.assertNotNull(hotelSaved.getStars());
        Assertions.assertNotNull(hotelSaved.getCity());
        Assertions.assertNotNull(hotelSaved.getAddress());
        Assertions.assertNotNull(hotelSaved.getLatitude());
        Assertions.assertNotNull(hotelSaved.getLongitude());
        Assertions.assertNotNull(hotelSaved.getPhoneNumber());
        Assertions.assertNotNull(hotelSaved.getEmail());
        Assertions.assertNotNull(hotelSaved.getCheckInTime());
        Assertions.assertNotNull(hotelSaved.getCheckOutTime());

        Assertions.assertEquals(hotel.getTitle(), hotelSaved.getTitle());
        Assertions.assertEquals(hotel.getDescription(), hotelSaved.getDescription());
        Assertions.assertEquals(hotel.isAcceptReservations(), hotelSaved.isAcceptReservations());
        Assertions.assertEquals(hotel.getStars(), hotelSaved.getStars());
        Assertions.assertEquals(hotel.getCity(), hotelSaved.getCity());
        Assertions.assertEquals(hotel.getAddress(), hotelSaved.getAddress());
        Assertions.assertEquals(hotel.getLatitude(), hotelSaved.getLatitude());
        Assertions.assertEquals(hotel.getLongitude(), hotelSaved.getLongitude());
        Assertions.assertEquals(hotel.getPhoneNumber(), hotelSaved.getPhoneNumber());
        Assertions.assertEquals(hotel.getEmail(), hotelSaved.getEmail());
        Assertions.assertEquals(hotel.getCheckInTime(), hotelSaved.getCheckInTime());
        Assertions.assertEquals(hotel.getCheckOutTime(), hotelSaved.getCheckOutTime());
    }

    @Test
    @DisplayName("update hotel test")
    public void givenHotelToUpdate_whenUpdateHotel_thenHotelIsUpdated(){
        //given
        String newAddress = "new address";
        Hotel hotel = Hotel.builder()
                .title("Grand Hotel")
                .description("Прекрасный отель с видом на море, расположенный в центре города. Идеальное место для отдыха и бизнес-поездок.")
                .isAcceptReservations(true)
                .stars((short) 5)
                .city("Санкт-Петербург")
                .address("Невский проспект, 1")
                .latitude(new BigDecimal("59.9358000"))
                .longitude(new BigDecimal("30.3256000"))
                .phoneNumber("+7 (812) 123-45-67")
                .email("info@grandhotel.ru")
                .checkInTime(LocalTime.of(14, 0))
                .checkOutTime(LocalTime.of(12, 0))
                .build();
        hotelRepository.save(hotel);
        //when
        Hotel updatedHotel = hotelRepository.findById(hotel.getId()).
                orElse(null);
        updatedHotel.setAddress(newAddress);
        //then
        Assertions.assertNotNull(updatedHotel.getId());
        Assertions.assertNotNull(updatedHotel.getTitle());
        Assertions.assertNotNull(updatedHotel.getDescription());
        Assertions.assertNotNull(updatedHotel.isAcceptReservations());
        Assertions.assertNotNull(updatedHotel.getStars());
        Assertions.assertNotNull(updatedHotel.getCity());
        Assertions.assertNotNull(updatedHotel.getAddress());
        Assertions.assertNotNull(updatedHotel.getLatitude());
        Assertions.assertNotNull(updatedHotel.getLongitude());
        Assertions.assertNotNull(updatedHotel.getPhoneNumber());
        Assertions.assertNotNull(updatedHotel.getEmail());
        Assertions.assertNotNull(updatedHotel.getCheckInTime());
        Assertions.assertNotNull(updatedHotel.getCheckOutTime());

        Assertions.assertEquals(hotel.getTitle(), updatedHotel.getTitle());
        Assertions.assertEquals(hotel.getDescription(), updatedHotel.getDescription());
        Assertions.assertEquals(hotel.isAcceptReservations(), updatedHotel.isAcceptReservations());
        Assertions.assertEquals(hotel.getStars(), updatedHotel.getStars());
        Assertions.assertEquals(hotel.getCity(), updatedHotel.getCity());
        Assertions.assertEquals(updatedHotel.getAddress(),newAddress);
        Assertions.assertEquals(hotel.getLatitude(), updatedHotel.getLatitude());
        Assertions.assertEquals(hotel.getLongitude(), updatedHotel.getLongitude());
        Assertions.assertEquals(hotel.getPhoneNumber(), updatedHotel.getPhoneNumber());
        Assertions.assertEquals(hotel.getEmail(), updatedHotel.getEmail());
        Assertions.assertEquals(hotel.getCheckInTime(), updatedHotel.getCheckInTime());
        Assertions.assertEquals(hotel.getCheckOutTime(), updatedHotel.getCheckOutTime());
    }

    @Test
    @DisplayName("Find by id hotel test")
    public void givenSavedHotel_whenFindById_thenHotelIsReturned(){
        //given
        Hotel hotel = Hotel.builder()
                .title("Grand Hotel")
                .description("Прекрасный отель с видом на море, расположенный в центре города. Идеальное место для отдыха и бизнес-поездок.")
                .isAcceptReservations(true)
                .stars((short) 5)
                .city("Санкт-Петербург")
                .address("Невский проспект, 1")
                .latitude(new BigDecimal("59.9358000"))
                .longitude(new BigDecimal("30.3256000"))
                .phoneNumber("+7 (812) 123-45-67")
                .email("info@grandhotel.ru")
                .checkInTime(LocalTime.of(14, 0))
                .checkOutTime(LocalTime.of(12, 0))
                .build();
        hotelRepository.save(hotel);
        //when
        Hotel findHotel = hotelRepository.findById(hotel.getId())
                .orElse(null);
        //then
        Assertions.assertNotNull(findHotel.getId());
        Assertions.assertNotNull(findHotel.getTitle());
        Assertions.assertNotNull(findHotel.getDescription());
        Assertions.assertNotNull(findHotel.isAcceptReservations());
        Assertions.assertNotNull(findHotel.getStars());
        Assertions.assertNotNull(findHotel.getCity());
        Assertions.assertNotNull(findHotel.getAddress());
        Assertions.assertNotNull(findHotel.getLatitude());
        Assertions.assertNotNull(findHotel.getLongitude());
        Assertions.assertNotNull(findHotel.getPhoneNumber());
        Assertions.assertNotNull(findHotel.getEmail());
        Assertions.assertNotNull(findHotel.getCheckInTime());
        Assertions.assertNotNull(findHotel.getCheckOutTime());

        Assertions.assertEquals(hotel.getTitle(), findHotel.getTitle());
        Assertions.assertEquals(hotel.getDescription(), findHotel.getDescription());
        Assertions.assertEquals(hotel.isAcceptReservations(), findHotel.isAcceptReservations());
        Assertions.assertEquals(hotel.getStars(), findHotel.getStars());
        Assertions.assertEquals(hotel.getCity(), findHotel.getCity());
        Assertions.assertEquals(hotel.getAddress(), findHotel.getAddress());
        Assertions.assertEquals(hotel.getLatitude(), findHotel.getLatitude());
        Assertions.assertEquals(hotel.getLongitude(), findHotel.getLongitude());
        Assertions.assertEquals(hotel.getPhoneNumber(), findHotel.getPhoneNumber());
        Assertions.assertEquals(hotel.getEmail(), findHotel.getEmail());
        Assertions.assertEquals(hotel.getCheckInTime(), findHotel.getCheckInTime());
        Assertions.assertEquals(hotel.getCheckOutTime(), findHotel.getCheckOutTime());
    }

    @Test
    @DisplayName("Find by id hotel test when hotel not found")
    public void givenSavedHotel_whenFindById_thenHotelNotFound(){
        //given
        //when
        Hotel hotel = hotelRepository.findById(UUID.randomUUID())
                .orElse(null);
        //then
        Assertions.assertNull(hotel);
    }


    @Test
    @DisplayName("Find all hotels test")
    public void givenSavedHotels_whenFindAll_thenHotelsIsReturned(){
        //given
        Hotel hotel1 = Hotel.builder()
                .title("Grand Hotel")
                .description("Прекрасный отель с видом на море, расположенный в центре города. Идеальное место для отдыха и бизнес-поездок.")
                .isAcceptReservations(true)
                .stars((short) 5)
                .city("Санкт-Петербург")
                .address("Невский проспект, 1")
                .latitude(new BigDecimal("59.9358000"))
                .longitude(new BigDecimal("30.3256000"))
                .phoneNumber("+7 (812) 123-45-67")
                .email("info@grandhotel.ru")
                .checkInTime(LocalTime.of(14, 0))
                .checkOutTime(LocalTime.of(12, 0))
                .build();
        Hotel hotel2 = Hotel.builder()
                .title("Cosmos Hotel")
                .description("Бюджетный отель в центре Москвы")
                .isAcceptReservations(true)
                .stars((short) 3)
                .city("Москва")
                .address("ул. Проспект Мира, 150")
                .latitude(new BigDecimal("55.7908000"))
                .longitude(new BigDecimal("37.6332000"))
                .phoneNumber("+7 (495) 123-4567")
                .email("book@cosmos-hotel.ru")
                .checkInTime(LocalTime.of(14, 0))
                .checkOutTime(LocalTime.of(12, 0))
                .build();
        Hotel hotel3 = Hotel.builder()
                .title("Grand Plaza Hotel")
                .description("Роскошный 5-звездочный отель в центре города с видом на море")
                .isAcceptReservations(true)
                .stars((short) 5)
                .city("Сочи")
                .address("ул. Курортная, 25")
                .latitude(new BigDecimal("43.5853000"))
                .longitude(new BigDecimal("39.7208000"))
                .phoneNumber("+7 (862) 123-45-67")
                .email("reservations@grandplaza.ru")
                .checkInTime(LocalTime.of(14, 0))
                .checkOutTime(LocalTime.of(12, 0))
                .build();
        hotelRepository.saveAll(List.of(hotel1,hotel2,hotel3));
        //when
        List<Hotel> hotels = hotelRepository.findAll();
        //then
        for (Hotel hotel : hotels) {
            Assertions.assertNotNull(hotel.getId());
            Assertions.assertNotNull(hotel.getTitle());
            Assertions.assertNotNull(hotel.getDescription());
            Assertions.assertNotNull(hotel.isAcceptReservations());
            Assertions.assertNotNull(hotel.getStars());
            Assertions.assertNotNull(hotel.getCity());
            Assertions.assertNotNull(hotel.getAddress());
            Assertions.assertNotNull(hotel.getLatitude());
            Assertions.assertNotNull(hotel.getLongitude());
            Assertions.assertNotNull(hotel.getPhoneNumber());
            Assertions.assertNotNull(hotel.getEmail());
            Assertions.assertNotNull(hotel.getCheckInTime());
            Assertions.assertNotNull(hotel.getCheckOutTime());
        }
    }

    @Test
    @DisplayName("Delete hotel test")
    public void givenHotelToDelete_whenDeleteHotel_thenHotelIsDeleted(){
        //given
        Hotel hotel = Hotel.builder()
                .title("Grand Hotel")
                .description("Прекрасный отель с видом на море, расположенный в центре города. Идеальное место для отдыха и бизнес-поездок.")
                .isAcceptReservations(true)
                .stars((short) 5)
                .city("Санкт-Петербург")
                .address("Невский проспект, 1")
                .latitude(new BigDecimal("59.9358000"))
                .longitude(new BigDecimal("30.3256000"))
                .phoneNumber("+7 (812) 123-45-67")
                .email("info@grandhotel.ru")
                .checkInTime(LocalTime.of(14, 0))
                .checkOutTime(LocalTime.of(12, 0))
                .build();
        hotelRepository.save(hotel);
        //when
        hotelRepository.deleteById(hotel.getId());
        //then
        Hotel hotelFound = hotelRepository.findById(hotel.getId())
                .orElse(null);
        Assertions.assertNull(hotelFound);
    }

}
