package az.it.hamburg.eventify.controller;

import az.it.hamburg.eventify.model.request.create.CreateTicketRequest;
import az.it.hamburg.eventify.model.response.TicketResponse;
import az.it.hamburg.eventify.service.concrete.TicketServiceHandler;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@SecurityRequirement(name = "BasicAuth")
@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketServiceHandler ticketServiceHandler;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTicket(@RequestBody @Valid CreateTicketRequest createTicketRequest) {
        ticketServiceHandler.saveTicket(createTicketRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTicket(@PathVariable Long id) {
        ticketServiceHandler.deleteTicket(id);
    }

    @GetMapping("/getTickets")
    @ResponseStatus(HttpStatus.OK)
    public Page<TicketResponse> getAllTicket(Pageable pageable) {
        return ticketServiceHandler.getAllTicket(pageable);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TicketResponse findTicketById(@PathVariable Long id) {
        return ticketServiceHandler.findTicketById(id);
    }
}
