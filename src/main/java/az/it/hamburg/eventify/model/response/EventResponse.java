package az.it.hamburg.eventify.model.response;

import az.it.hamburg.eventify.model.enums.EventStatus;
import az.it.hamburg.eventify.model.enums.EventType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventResponse {
    Long id;
    String title;
    String description;
    String location;
    EventStatus eventStatus;
    EventType eventType;
    LocalDateTime eventDate;
    BigDecimal price;
}
