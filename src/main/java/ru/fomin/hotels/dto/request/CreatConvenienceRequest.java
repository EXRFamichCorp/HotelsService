package ru.fomin.hotels.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatConvenienceRequest {

    @JsonProperty(value = "category")
    private ConvenienceCategoryRequest category;

    @JsonProperty(value = "title")
    private String title;

}
