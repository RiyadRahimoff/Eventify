package az.it.hamburg.eventify.service.abstraction;

import az.it.hamburg.eventify.model.request.create.CreateTicketRequest;
import az.it.hamburg.eventify.model.response.TicketResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
    void saveTicket(CreateTicketRequest createTicketRequest);

    void deleteTicket(Long id);

    Page<TicketResponse> getAllTicket(Pageable pageable);

    TicketResponse findTicketById(Long id);
}
