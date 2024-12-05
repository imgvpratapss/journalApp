package net.engineeringdigest.journalApp.pojo.labs11.pronunciationdictionaries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PronunciationDictionary {
    public String id;
    public String latest_version_id;
    public String name;
    public String created_by;
    public int creation_time_unix;
    public String description;
}
