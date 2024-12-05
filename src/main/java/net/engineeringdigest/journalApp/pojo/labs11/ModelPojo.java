package net.engineeringdigest.journalApp.pojo.labs11;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelPojo {
    @JsonProperty("model_id")
    private String modelId;
    private String name;
    @JsonProperty("can_be_finetuned")
    private boolean canBeFinetuned;
    @JsonProperty("can_do_text_to_speech")
    private boolean canDoTextToSpeech;
    @JsonProperty("can_do_voice_conversion")
    private boolean canDoVoiceConversion;
    @JsonProperty("can_use_style")
    private boolean canUseStyle;
    @JsonProperty("can_use_speaker_boost")
    private boolean canUseSpeakerBoost;
    @JsonProperty("serves_pro_voices")
    private boolean servesProVoices;
    @JsonProperty("token_cost_factor")
    private double tokenCostFactor;
    private String description;
    @JsonProperty("requires_alpha_access")
    private boolean requiresAlphaAccess;
    @JsonProperty("max_characters_request_free_user")
    private int maxCharactersRequestFreeUser;
    @JsonProperty("max_characters_request_subscribed_user")
    private int maxCharactersRequestSubscribedUser;
    @JsonProperty("maximum_text_length_per_request")
    private int maximumTextLengthPerRequest;
    private ArrayList<Language> languages;
    @JsonProperty("model_rates")
    private ModelRates modelRates;
    @JsonProperty("concurrency_group")
    private String concurrencyGroup;
    private String text;
}
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
 class Language{
    @JsonProperty("language_id")
    private String languageId;
    private String name;
}
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
 class ModelRates{
    @JsonProperty("character_cost_multiplier")
    private double characterCostMultiplier;
}
