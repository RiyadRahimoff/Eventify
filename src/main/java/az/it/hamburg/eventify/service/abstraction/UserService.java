package az.it.hamburg.eventify.service.abstraction;

import az.it.hamburg.eventify.model.request.CreateUserRequest;
import az.it.hamburg.eventify.model.request.UpdateUserRequest;
import az.it.hamburg.eventify.model.response.UserResponse;

import java.util.List;

public interface UserService {
    void saveUser(CreateUserRequest createUserRequest);

    void deleteUser(Long id);

    List<UserResponse> getAllUser();

    UserResponse findUserById(Long id);

     void updateUser(Long id, UpdateUserRequest updateUserRequest);
}
