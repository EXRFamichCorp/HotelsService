package ru.fomin.hotels.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NonAvailableRoomCategoryDto {

    private int id;
    private String title;
    private String[] imageUrls;
    private String[] convenienceIconUrls ;
}
