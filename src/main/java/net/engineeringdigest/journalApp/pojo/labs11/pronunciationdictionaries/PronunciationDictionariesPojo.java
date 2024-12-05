package net.engineeringdigest.journalApp.pojo.labs11.pronunciationdictionaries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PronunciationDictionariesPojo {
    public ArrayList<PronunciationDictionary> pronunciation_dictionaries;
    public String next_cursor;
    public boolean has_more;
}


