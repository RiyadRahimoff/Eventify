package az.it.hamburg.eventify.service.abstraction;

import az.it.hamburg.eventify.model.request.create.CreateUserRequest;
import az.it.hamburg.eventify.model.request.update.UpdateUserRequest;
import az.it.hamburg.eventify.model.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    void saveUser(CreateUserRequest createUserRequest);

    void deleteUser(Long id);

    //    Page<UserResponse> getAllUser(Pageable pageable);

    UserResponse findUserById(Long id);

    void updateUser(Long id, UpdateUserRequest updateUserRequest);
}
