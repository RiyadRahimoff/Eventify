package az.it.hamburg.eventify.model.request;

import az.it.hamburg.eventify.model.enums.EventType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class UpdateEventRequest {

    String title;

    String description;

    @NotNull(message = "Location field cannot be empty")
    private Long locationId;

    LocalDateTime eventDate;

    EventType eventType;

    @NotNull(message = "Price field cannot be empty")
    BigDecimal price;

}
