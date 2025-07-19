package ru.fomin.hotels.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import ru.fomin.hotels.dto.request.ConvenienceCategoryRequest;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAllConvenienceCategoryResponse {

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "category")
    private ConvenienceCategoryRequest category;

    @JsonProperty(value = "title")
    private String title;
}
