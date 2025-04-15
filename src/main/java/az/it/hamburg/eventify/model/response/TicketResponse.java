package az.it.hamburg.eventify.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class TicketResponse {
    Long id;
    Long userId;
    String userName;
    Long eventId;
    String eventName;
    BigDecimal price;
    String seatNumber;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}