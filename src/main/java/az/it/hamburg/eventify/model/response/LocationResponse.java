package az.it.hamburg.eventify.model.response;

import az.it.hamburg.eventify.model.enums.LocationStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class LocationResponse {
    private Long id;
    String name;
    String address;
    String city;
    String country;
    String mapUrl;
    LocationStatus locationStatus;

}
