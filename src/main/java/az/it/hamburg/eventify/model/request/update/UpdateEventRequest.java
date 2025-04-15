package az.it.hamburg.eventify.model.request.update;

import az.it.hamburg.eventify.model.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class UpdateEventRequest {
    String title;
    String description;
    Long locationId;
    LocalDateTime eventDate;
    EventType eventType;
    BigDecimal price;
}
