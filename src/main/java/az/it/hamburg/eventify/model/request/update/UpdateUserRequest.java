package az.it.hamburg.eventify.model.request.update;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateUserRequest {
    String name;
    String surname;
    @Email(regexp = "^[\\w.-]+@[\\w.-]+\\.(com|ru)$", message = "The email must also have the @ symbol and end with .com or .ru.")
    String email;
    @Size(min = 8, max = 250, message = "Password must be between 8 and 255 characters")
    String password;
    BigDecimal balance;
}
