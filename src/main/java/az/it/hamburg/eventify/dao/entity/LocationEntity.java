package az.it.hamburg.eventify.dao.entity;

import az.it.hamburg.eventify.model.enums.LocationStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Builder
@Where(clause = "location_status <> 'DE_ACTIVE'")
@Table(name = "locations")
@FieldDefaults(level = PRIVATE)
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String name;

    String address;

    String city;

    String country;

    String mapUrl;

    @Enumerated(STRING)
    LocationStatus locationStatus;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    @OneToMany(mappedBy = "location", cascade = {MERGE, PERSIST})
    List<EventEntity> events;
}
