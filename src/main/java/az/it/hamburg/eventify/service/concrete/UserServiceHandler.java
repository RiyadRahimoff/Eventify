package az.it.hamburg.eventify.service.concrete;

import az.it.hamburg.eventify.dao.entity.UserEntity;
import az.it.hamburg.eventify.dao.repository.UserRepository;
import az.it.hamburg.eventify.exception.UserNotFound;
import az.it.hamburg.eventify.mapper.UserMapper;
import az.it.hamburg.eventify.model.enums.UserStatus;
import az.it.hamburg.eventify.model.request.create.CreateUserRequest;
import az.it.hamburg.eventify.model.request.update.UpdateUserRequest;
import az.it.hamburg.eventify.model.response.UserResponse;
import az.it.hamburg.eventify.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.it.hamburg.eventify.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserServiceHandler implements UserService {
    private final UserRepository userRepository;

    @Override
    public void saveUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity = USER_MAPPER.requestToEntity(createUserRequest);
        userEntity.setUserStatus(UserStatus.ACTIVE);
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound("User not found " + id));
        userEntity.setUserStatus(UserStatus.DE_ACTIVE);
        userRepository.save(userEntity);
    }


//    @Override
//    public Page<UserResponse> getAllUser(Pageable pageable) {
//        Page<UserEntity> users = userRepository.findAll(pageable);
//
//        // Debug üçün, gələn istifadəçiləri logla
//        users.forEach(user -> System.out.println(user.getUserStatus())); // Gələn bütün statusları logla
//
//        List<UserResponse> activeUsers = users.getContent().stream()
//                .filter(user -> user.getUserStatus().equals(UserStatus.ACTIVE))
//                .map(UserMapper::entityToResponse)
//                .toList();
//
//        return new PageImpl<>(activeUsers, pageable, activeUsers.size());
//    }



    @Override
    public UserResponse findUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()
                -> new UserNotFound("User with the provided " + id + " was not found."));
        UserResponse userResponse = USER_MAPPER.entityToResponse(userEntity);
        return userResponse;
    }

    @Override
    public void updateUser(Long id, UpdateUserRequest updateUserRequest) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()
                -> new UserNotFound("User not found! " + id));

        if (updateUserRequest.getName() != null) {
            userEntity.setName(updateUserRequest.getName());
        }
        if (updateUserRequest.getSurname() != null) {
            userEntity.setSurname(updateUserRequest.getSurname());
        }
        if (updateUserRequest.getEmail() != null) {
            userEntity.setEmail(updateUserRequest.getEmail());
        }
        if (updateUserRequest.getPassword() != null) {
            userEntity.setPassword(updateUserRequest.getPassword());
        }
        if (updateUserRequest.getBalance() != null) {
            userEntity.setBalance(updateUserRequest.getBalance());
        }
        userEntity.setUserStatus(UserStatus.IN_PROGRESS);

        userRepository.save(userEntity);
    }

}
