package net.engineeringdigest.journalApp.pojo.labs11.voice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;
@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VoiceResponse {
    public ArrayList<Voice> voices;


}
@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
 class FineTuning{
    public boolean is_allowed_to_fine_tune;
    public State state;
    public ArrayList<Object> verification_failures;
    public int verification_attempts_count;
    public boolean manual_verification_requested;
    public String language;
    public Progress progress;
    public Message message;
    public Object dataset_duration_seconds;
    public Object verification_attempts;
    public Object slice_ids;
    public Object manual_verification;
    public int max_verification_attempts;
    public Object next_max_verification_attempts_reset_unix_ms;
}
@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
 class Labels{
    public String accent;
    public String description;
    public String age;
    public String gender;
    public String use_case;
}
@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
 class Message{
    public String eleven_multilingual_v2;
    public String eleven_turbo_v2_5;
    public String eleven_turbo_v2;
    public String eleven_multilingual_sts_v2;
}
@Setter
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
 class Progress{
}
@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
 class State{
    public String eleven_multilingual_v2;
    public String eleven_turbo_v2_5;
    public String eleven_turbo_v2;
    public String eleven_multilingual_sts_v2;
}

@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
 class VoiceVerification{
    public boolean requires_verification;
    public boolean is_verified;
    public ArrayList<Object> verification_failures;
    public int verification_attempts_count;
    public Object language;
    public Object verification_attempts;
}

