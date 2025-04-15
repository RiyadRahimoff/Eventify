package az.it.hamburg.eventify.dao.entity;

import az.it.hamburg.eventify.model.enums.EventStatus;
import az.it.hamburg.eventify.model.enums.EventType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "events")
@Where(clause = "event_status <> 'DE_ACTIVE'")
@FieldDefaults(level = PRIVATE)
public class EventEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String title;

    BigDecimal price;

    String description;

    @Enumerated(STRING)
    EventStatus eventStatus;

    @Enumerated(STRING)
    EventType eventType;

    LocalDateTime eventDate;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    @OneToMany(mappedBy = "event", cascade = {PERSIST, MERGE})
    List<TicketEntity> tickets;

    @ManyToOne(fetch = LAZY, cascade = MERGE)
    LocationEntity location;
}
