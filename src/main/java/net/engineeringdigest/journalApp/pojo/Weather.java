package net.engineeringdigest.journalApp.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
class WeatherResponse {
    @JsonProperty("observation_time")
    public String observationTime;
    public int temperature;
    @JsonProperty("weather_code")
    public int weatherCode;
    @JsonProperty("weather_icons")
    public ArrayList<String> weatherIcons;
    @JsonProperty("weather_descriptions")
    public ArrayList<String> weatherDescriptions;
    @JsonProperty("wind_speed")
    public int windSpeed;
    @JsonProperty("wind_degree")
    public int windDegree;
    @JsonProperty("wind_dir")
    public String windDir;
    public int pressure;
    public int precip;
    public int humidity;
    public int cloudcover;
    public int feelslike;
    @JsonProperty("uv_index")
    public int uvIndex;
    public int visibility;
    @JsonProperty("is_day")
    public String isDay;

    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */






}
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor

 class Request {
    public String type;
    public String query;
    public String language;
    public String unit;
}

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
 public class Weather {
    public Request request;
    public Location location;
    @JsonProperty("current")
    public WeatherResponse weatherResponse;
}

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
 class Location {
    public String name;
    public String country;
    public String region;
    public String lat;
    public String lon;
    @JsonProperty("timezone_id")
    public String timezoneId;
    public String localtime;
    @JsonProperty("localtime_epoch")
    public int localtimeEpoch;
    @JsonProperty("utc_offset")
    public String utcOffset;
}




