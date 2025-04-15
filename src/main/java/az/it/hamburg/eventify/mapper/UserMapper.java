package az.it.hamburg.eventify.mapper;

import az.it.hamburg.eventify.dao.entity.UserEntity;
import az.it.hamburg.eventify.model.request.CreateUserRequest;
import az.it.hamburg.eventify.model.response.TicketResponse;
import az.it.hamburg.eventify.model.response.UserResponse;

public enum UserMapper {
    USER_MAPPER;

    public UserEntity requestToEntity(CreateUserRequest createUserRequest) {
        return UserEntity.builder()
                .name(createUserRequest.getName())
                .surname(createUserRequest.getSurname())
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword()).
                balance(createUserRequest.getBalance())
                .build();
    }

    public static UserResponse entityToResponse(UserEntity userEntity) {
        return UserResponse.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .email(userEntity.getEmail())
                .balance(userEntity.getBalance())
                .userStatus(userEntity.getUserStatus())
                .tickets(userEntity.getTickets() != null
                        ? userEntity.getTickets().stream()
                        .map(ticket -> TicketResponse.builder()
                                .id(ticket.getId())
                                .seatNumber(ticket.getSeatNumber())
                                .price(ticket.getPrice())
                                .build())
                        .toList()
                        : null)
                .build();
    }
}

