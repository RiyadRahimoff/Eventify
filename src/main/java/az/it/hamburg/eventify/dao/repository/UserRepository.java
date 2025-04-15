package az.it.hamburg.eventify.dao.repository;

import az.it.hamburg.eventify.dao.entity.UserEntity;
import az.it.hamburg.eventify.model.enums.UserStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

        Optional<UserEntity> findByUsername(String username);
}
