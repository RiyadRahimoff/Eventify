package az.it.hamburg.eventify.service.abstraction;

import az.it.hamburg.eventify.model.request.CreateEventRequest;
import az.it.hamburg.eventify.model.request.UpdateEventRequest;
import az.it.hamburg.eventify.model.response.EventResponse;

import java.util.List;

public interface EventService {
    void saveEvent(CreateEventRequest createEventRequest);

    void deleteEvent(Long id);

    List<EventResponse> getEvents();

    EventResponse getEventById(Long id);

    void updateEvent(Long id, UpdateEventRequest updateEventRequest);

}
