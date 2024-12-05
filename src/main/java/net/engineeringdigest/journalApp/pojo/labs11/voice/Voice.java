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
public class Voice{
    public String voice_id;
    public String name;
    public Object samples;
    public String category;
    public FineTuning fine_tuning;
    public Labels labels;
    public Object description;
    public String preview_url;
    public ArrayList<Object> available_for_tiers;
    public Object settings;
    public Object sharing;
    public ArrayList<String> high_quality_base_model_ids;
    public Object safety_control;
    public VoiceVerification voice_verification;
    public Object permission_on_resource;
    public boolean is_owner;
    public boolean is_legacy;
    public boolean is_mixed;
    public Object created_at_unix;
}
