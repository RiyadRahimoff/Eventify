package az.it.hamburg.eventify.model.request.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class CreateUserRequest {
    @NotEmpty(message = "Name field cannot be empty")
    String name;

    @NotEmpty(message = "Surname field cannot be empty")
    String surname;

    @NotBlank(message = "email can't be blank")
    @Email(regexp = "^[\\w.-]+@[\\w.-]+\\.(com|ru)$", message = "The email must also have the @ symbol and end with .com or .ru.")
    String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 250, message = "Password must be between 8 and 255 characters")
    String password;


    @NotNull(message = "Balance must be provided")
    BigDecimal balance;

}