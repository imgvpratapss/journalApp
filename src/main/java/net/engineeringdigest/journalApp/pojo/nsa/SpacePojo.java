package net.engineeringdigest.journalApp.pojo.nsa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpacePojo {
        private String date;
        private String explanation;
        @JsonProperty("hdurl")
        private String hdUrl;
        @JsonProperty("media_type")
        private String mediaType;
        @JsonProperty("service_version")
        private String serviceVersion;
        private String title;
        private String url;

}
