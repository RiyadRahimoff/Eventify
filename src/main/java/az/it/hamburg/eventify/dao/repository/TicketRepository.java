package az.it.hamburg.eventify.dao.repository;

import az.it.hamburg.eventify.dao.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Long> {
}
