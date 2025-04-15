package az.it.hamburg.eventify.model.request.create;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class CreateLocationRequest {
    @NotEmpty(message = "Name field cannot be empty")
    String name;

    @NotEmpty(message = "Address field cannot be empty")
    String address;

    @NotEmpty(message = "City field cannot be empty")
    String city;

    @NotEmpty(message = "Country field cannot be empty")
    String country;

    @NotNull(message = "Url field cannot be empty")
    String mapUrl;

}
