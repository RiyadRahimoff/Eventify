package az.it.hamburg.eventify.model.response;

import az.it.hamburg.eventify.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class UserResponse {
    Long id;
    String name;
    String surname;
    String email;
    BigDecimal balance;
    UserStatus userStatus;
    @Builder.Default
    List<TicketResponse> tickets = new ArrayList<>();
}
