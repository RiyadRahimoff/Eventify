package az.it.hamburg.eventify.service.concrete;

import az.it.hamburg.eventify.dao.entity.EventEntity;
import az.it.hamburg.eventify.dao.entity.TicketEntity;
import az.it.hamburg.eventify.dao.entity.UserEntity;
import az.it.hamburg.eventify.dao.repository.EventRepository;
import az.it.hamburg.eventify.dao.repository.TicketRepository;
import az.it.hamburg.eventify.dao.repository.UserRepository;
import az.it.hamburg.eventify.exception.EventNotFound;
import az.it.hamburg.eventify.exception.InsufficientBalanceException;
import az.it.hamburg.eventify.exception.TicketNotFound;
import az.it.hamburg.eventify.exception.UserNotFound;
import az.it.hamburg.eventify.mapper.TicketMapper;
import az.it.hamburg.eventify.model.enums.TicketStatus;
import az.it.hamburg.eventify.model.request.create.CreateTicketRequest;
import az.it.hamburg.eventify.model.response.TicketResponse;
import az.it.hamburg.eventify.service.abstraction.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceHandler implements TicketService {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public void saveTicket(CreateTicketRequest createTicketRequest) {
        EventEntity event = eventRepository.findById(createTicketRequest.getEventId())
                .orElseThrow(() -> new EventNotFound("Event not found with id: " + createTicketRequest.getEventId()));

        UserEntity user = userRepository.findById(createTicketRequest.getUserId())
                .orElseThrow(() -> new UserNotFound("User not found with id: " + createTicketRequest.getUserId()));

        TicketEntity ticket = new TicketEntity();
        ticket.setSeatNumber(createTicketRequest.getSeatNumber());
        ticket.setEvent(event);
        ticket.setUser(user);
        ticket.setPrice(event.getPrice());
        ticket.setTicketStatus(TicketStatus.ACTIVE);

        if (user.getBalance().compareTo(event.getPrice()) < 0) {
            throw new InsufficientBalanceException("User does not have enough balance to purchase the ticket.");
        }

        user.setBalance(user.getBalance().subtract(event.getPrice()));
        userRepository.save(user);

        ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        TicketEntity ticketEntity = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFound("Ticket not found!"));
        ticketEntity.setTicketStatus(TicketStatus.DE_ACTIVE);
        ticketRepository.save(ticketEntity);
    }

    @Override
    public Page<TicketResponse> getAllTicket(Pageable pageable) {

        Page<TicketEntity> ticketEntities = ticketRepository.findAll(pageable);
        Page<TicketResponse> ticketResponses = ticketEntities.map(ticket ->
                TicketMapper.TICKET_MAPPER.entityToResponse(ticket)
        );

        return ticketResponses;
    }

    @Override
    public TicketResponse findTicketById(Long id) {
        TicketEntity ticketEntity = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFound("Ticket not found!"));
        TicketResponse ticketResponse = TicketMapper.entityToResponse(ticketEntity);
        return ticketResponse;
    }
}
