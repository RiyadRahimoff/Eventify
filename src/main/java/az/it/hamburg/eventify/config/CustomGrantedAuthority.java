package az.it.hamburg.eventify.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomGrantedAuthority implements GrantedAuthority {
    String authority;

    public CustomGrantedAuthority(Role role) {
        this.authority = role.name();
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}