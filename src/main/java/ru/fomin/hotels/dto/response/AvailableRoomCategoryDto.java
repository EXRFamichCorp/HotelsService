package ru.fomin.hotels.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.type.Decimal;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvailableRoomCategoryDto {

    @JsonProperty(value = "id")
    private int id;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "urls")
    private String[] imageUrls;

    private String[] convenienceIconUrls;

    private Decimal averagePriceForPeriod;

    private int minimalRoomsNumber;


}
