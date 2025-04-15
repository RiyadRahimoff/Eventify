package az.it.hamburg.eventify.config;

import az.it.hamburg.eventify.dao.repository.UserRepository;
import az.it.hamburg.eventify.exception.UserNotFound;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class CustomUserDetails implements UserDetailsService {
        UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            var user = userRepository.findByUsername(username).orElseThrow(() ->
                    new UsernameNotFoundException("User not found"));

            var customGrantedAuthorities = user.getAuthorities().stream()
                    .map(authority -> new CustomGrantedAuthority(Role.valueOf(authority.getAuthority())))
                    .collect(Collectors.toSet());

            return new CustomUserDetails(user, customGrantedAuthorities);
        }

    }

