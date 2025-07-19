package ru.fomin.hotels.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateConvenienceCategoryRequest {

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "url")
    private String iconUrl;

}
