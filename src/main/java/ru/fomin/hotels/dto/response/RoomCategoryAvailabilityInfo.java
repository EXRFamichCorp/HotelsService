package ru.fomin.hotels.dto.response;

import com.google.type.Decimal;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomCategoryAvailabilityInfo {

    private int id;
    private Decimal averagePriceForPeriod;
    private int minAvailableRoomsNumber;

}
