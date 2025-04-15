package az.it.hamburg.eventify.dao.repository;

import az.it.hamburg.eventify.dao.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity,Long> {
}
