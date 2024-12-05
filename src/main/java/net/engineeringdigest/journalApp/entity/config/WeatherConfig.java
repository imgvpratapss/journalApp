package net.engineeringdigest.journalApp.entity.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@NoArgsConstructor
//@AllArgsConstructor
public class WeatherConfig {
    private String key;
    private String value;
    @JsonProperty("base_url")
    private String base_url;
    private String test;
}
