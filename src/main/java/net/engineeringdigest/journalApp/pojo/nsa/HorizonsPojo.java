package net.engineeringdigest.journalApp.pojo.nsa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class HorizonsPojo {
    public Signature signature;
    public String result;
    @Getter
    @Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    public class Signature{
        public String source;
        public String version;
    }
}
