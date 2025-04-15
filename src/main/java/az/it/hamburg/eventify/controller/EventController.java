package az.it.hamburg.eventify.controller;

import az.it.hamburg.eventify.model.request.create.CreateEventRequest;
import az.it.hamburg.eventify.model.request.update.UpdateEventRequest;
import az.it.hamburg.eventify.model.response.EventResponse;
import az.it.hamburg.eventify.service.concrete.EventServiceHandler;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "BasicAuth")
@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {
    private final EventServiceHandler eventServiceHandler;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEvent(@RequestBody @Valid CreateEventRequest createEventRequest) {
        eventServiceHandler.saveEvent(createEventRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEvent(@PathVariable Long id) {
        eventServiceHandler.deleteEvent(id);
    }

    @GetMapping("/getEvents")
    @ResponseStatus(HttpStatus.OK)
    public Page<EventResponse> getEvents(Pageable pageable) {
        return eventServiceHandler.getEvents(pageable);
    }


    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EventResponse getEventById(@PathVariable Long id) {
        return eventServiceHandler.getEventById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEvent(@PathVariable Long id, @RequestBody @Valid UpdateEventRequest updateEventRequest) {
        eventServiceHandler.updateEvent(id, updateEventRequest);
    }

}
