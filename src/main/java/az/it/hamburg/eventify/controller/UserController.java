package az.it.hamburg.eventify.controller;

import az.it.hamburg.eventify.model.request.create.CreateUserRequest;
import az.it.hamburg.eventify.model.request.update.UpdateUserRequest;
import az.it.hamburg.eventify.model.response.UserResponse;
import az.it.hamburg.eventify.service.concrete.UserServiceHandler;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "BasicAuth")
@RestController
@RequestMapping("/eventify/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceHandler userServiceHandler;

    @PostMapping("/saveUser")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        userServiceHandler.saveUser(createUserRequest);
    }

    @DeleteMapping("/deleteUser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id) {
        userServiceHandler.deleteUser(id);
    }

//    @GetMapping("/getUsers")
//    @ResponseStatus(HttpStatus.OK)
//    public Page<UserResponse> getAllUser(Pageable pageable) {
//        return userServiceHandler.getAllUser(pageable);
//    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse findUserById(@PathVariable Long id) {
        UserResponse userById = userServiceHandler.findUserById(id);
        return userById;
    }

    @PutMapping("/update/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable Long id, @RequestBody @Valid UpdateUserRequest updateUserRequest) {
        userServiceHandler.updateUser(id, updateUserRequest);
    }
}

