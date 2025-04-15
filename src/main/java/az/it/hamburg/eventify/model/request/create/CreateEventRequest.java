package az.it.hamburg.eventify.model.request.create;

import az.it.hamburg.eventify.model.enums.EventType;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class CreateEventRequest {

    @NotBlank(message = "Title field cannot be empty")
    String title;

    @NotBlank(message = "Description field cannot be empty")
    String description;

    @NotNull(message = "Location ID cannot be null")
    Long locationId;

    @NotNull(message = "Date field cannot be null")
    LocalDateTime eventDate;

    @NotNull(message = "Price cannot be null")
    BigDecimal price;

    @NotNull(message = "Event type must be selected")
    EventType eventType;
}
