package az.it.hamburg.eventify.dao.repository;

import az.it.hamburg.eventify.dao.entity.UserEntity;
import az.it.hamburg.eventify.model.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findAllByUserStatus(UserStatus userStatus);
}
