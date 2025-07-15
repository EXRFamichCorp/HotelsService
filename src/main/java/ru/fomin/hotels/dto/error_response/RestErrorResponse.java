package ru.fomin.hotels.dto.error_response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.net.URI;
import java.time.Instant;
import java.util.Dictionary;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestErrorResponse {

    private URI type;

    private String title;

    private int status;

    private String detail;

    private Instant timestamp;

    private String instance;

    private Dictionary<String, Object> metadata;

}
