package az.it.hamburg.eventify.service.abstraction;

import az.it.hamburg.eventify.model.request.create.CreateEventRequest;
import az.it.hamburg.eventify.model.request.update.UpdateEventRequest;
import az.it.hamburg.eventify.model.response.EventResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EventService {
    void saveEvent(CreateEventRequest createEventRequest);

    void deleteEvent(Long id);

    Page<EventResponse> getEvents(Pageable pageable);;

    EventResponse getEventById(Long id);

    void updateEvent(Long id, UpdateEventRequest updateEventRequest);

}
