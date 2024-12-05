package net.engineeringdigest.journalApp.pojo.labs11;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.MediaType;


import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElevenLabsPojo {
    private String text;
    @JsonProperty("model_id")
    private String modelId;
    @JsonProperty("language_code")
    private String languageCode;
    @JsonProperty("voice_settings")
    private VoiceSettingsPojo voiceSettings;
    @JsonProperty("pronunciation_dictionary_locators")
    private PronunciationDictionaryLocators array;
    private Integer seed;
    @JsonProperty("previous_text")
    private String previousText;
    @JsonProperty("next_text")
    private String nextText;
    @JsonProperty("previous_request_ids")
    private String[] previousRequestIds;
    @JsonProperty("next_request_ids")
    private String[] nextRequestIds;
    @JsonProperty("use_pvc_as_ivc")
    private Boolean usePvcAsIvc;
    @JsonProperty("apply_text_normalization")
    private Penum applyTextNormalization;
    private Map<?,?> newProperty;
    @JsonProperty("voice_id")
    private String voiceId;

    private String media;


    enum Penum{
        auto,on,off
    }
}
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
 class VoiceSettingsPojo{
    private Number stability;
    @JsonProperty("similarity_boost")
    private Number similarityBoost;
    private Number style;
    @JsonProperty("use_speaker_boost")
    private Boolean useSpeakerBoost;
    private Map<?,?> newProperty;
}

@Getter
@Setter
@Builder
 class PronunciationDictionaryLocators{
    private Map<?,?> newProperty;
    private PrDL object;
}
@Getter
@Setter
@Builder
 class PrDL{
    @JsonProperty("pronunciation_dictionary_id")
    private String pronunciationDictionaryId;
    @JsonProperty("version_id")
    private String versionId;
    private Map<?,?> newProperty;
}
