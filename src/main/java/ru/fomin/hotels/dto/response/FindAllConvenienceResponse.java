package ru.fomin.hotels.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ru.fomin.hotels.dto.request.ConvenienceCategoryForFindAllRequest;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAllConvenienceResponse {

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "category")
    private ConvenienceCategoryForFindAllRequest category;

    @JsonProperty(value = "title")
    private String title;

}
