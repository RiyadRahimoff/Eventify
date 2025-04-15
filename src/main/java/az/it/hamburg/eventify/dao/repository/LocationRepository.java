package az.it.hamburg.eventify.dao.repository;

import az.it.hamburg.eventify.dao.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity,Long> {
}
