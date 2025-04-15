package az.it.hamburg.eventify.dao.entity;

import az.it.hamburg.eventify.model.enums.TicketStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Builder
@Table(name = "tickets")
@FieldDefaults(level = PRIVATE)
@Where(clause = "ticket_status <> 'DE_ACTIVE'")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    BigDecimal price;

    String seatNumber;

    @Enumerated(STRING)
    TicketStatus ticketStatus;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    @ManyToOne(fetch = EAGER)
    UserEntity user;

    @ManyToOne
    EventEntity event;

}
