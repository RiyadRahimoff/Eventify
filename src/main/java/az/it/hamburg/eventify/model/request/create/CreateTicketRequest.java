package az.it.hamburg.eventify.model.request.create;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateTicketRequest {
    @NotEmpty(message = "User id field cannot be empty")
    Long userId;
    @NotEmpty(message = "Event id field cannot be empty")
    Long eventId;
    @NotEmpty(message = "Seat Number field cannot be empty")
    String seatNumber;
}

