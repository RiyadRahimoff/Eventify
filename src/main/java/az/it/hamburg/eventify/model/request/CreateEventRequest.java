package az.it.hamburg.eventify.model.request;

import az.it.hamburg.eventify.model.enums.EventType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateEventRequest {
    @NotEmpty(message = "Title field cannot be empty")
    String title;
    @NotEmpty(message = "Description field cannot be empty")
    String description;
    @NotEmpty(message = "Location field cannot be empty")
    private Long locationId;
    @NotEmpty(message = "Date field cannot be empty")
    LocalDateTime eventDate;
    @NotEmpty(message = "Price field cannot be empty")
    BigDecimal price;
    @NotEmpty(message = "Type must be selected")
    EventType eventType;


}
