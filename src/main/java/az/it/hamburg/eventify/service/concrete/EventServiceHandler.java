package az.it.hamburg.eventify.service.concrete;

import az.it.hamburg.eventify.dao.entity.EventEntity;
import az.it.hamburg.eventify.dao.entity.LocationEntity;
import az.it.hamburg.eventify.dao.repository.EventRepository;
import az.it.hamburg.eventify.dao.repository.LocationRepository;
import az.it.hamburg.eventify.exception.EventNotFound;
import az.it.hamburg.eventify.exception.LocationNotFound;
import az.it.hamburg.eventify.mapper.EventMapper;
import az.it.hamburg.eventify.model.enums.EventStatus;
import az.it.hamburg.eventify.model.request.create.CreateEventRequest;
import az.it.hamburg.eventify.model.request.update.UpdateEventRequest;
import az.it.hamburg.eventify.model.response.EventResponse;
import az.it.hamburg.eventify.service.abstraction.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceHandler implements EventService {
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    @Override
    public void saveEvent(CreateEventRequest createEventRequest) {
        LocationEntity location = locationRepository.findById(createEventRequest.getLocationId())
                .orElseThrow(() -> new LocationNotFound("Location tapılmadı"));
        EventEntity eventEntity = EventMapper.EVENT_MAPPER.requestToEntity(createEventRequest, location);
        eventEntity.setEventStatus(EventStatus.ACTIVE);
        eventRepository.save(eventEntity);
    }


    @Override
    public void deleteEvent(Long id) {
        EventEntity eventEntity = eventRepository.findById(id).orElseThrow(() -> new EventNotFound("Event not found"));
        eventEntity.setEventStatus(EventStatus.DE_ACTIVE);
        eventRepository.save(eventEntity);
    }

    @Override
    public Page<EventResponse> getEvents(Pageable pageable) {
        Page<EventEntity> events = eventRepository.findAll(pageable);

        List<EventResponse> filtered = events.stream()
                .filter(event -> event.getEventStatus().equals(EventStatus.ACTIVE))
                .map(EventMapper::entityToResponse)
                .toList();

        return new PageImpl<>(filtered, pageable, filtered.size());
    }

    @Override
    public EventResponse getEventById(Long id) {
        EventEntity eventEntity = eventRepository.findById(id).orElseThrow(() -> new EventNotFound("Event not found"));
        EventResponse eventresponse = EventMapper.entityToResponse(eventEntity);
        return eventresponse;
    }

    @Override
    public void updateEvent(Long id, UpdateEventRequest updateEventRequest) {
        EventEntity eventEntity = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFound("Event not found with id: " + id));

        if (updateEventRequest.getTitle() != null) {
            eventEntity.setTitle(updateEventRequest.getTitle());
        }
        if (updateEventRequest.getDescription() != null) {
            eventEntity.setDescription(updateEventRequest.getDescription());
        }
        if (updateEventRequest.getPrice() != null) {
            eventEntity.setPrice(updateEventRequest.getPrice());
        }
        if (updateEventRequest.getEventDate() != null) {
            eventEntity.setEventDate(updateEventRequest.getEventDate());
        }
        if (updateEventRequest.getEventType() != null) {
            eventEntity.setEventType(updateEventRequest.getEventType());
        }

        if (updateEventRequest.getLocationId() != null) {
            LocationEntity location = locationRepository.findById(updateEventRequest.getLocationId())
                    .orElseThrow(() -> new LocationNotFound("Location not found with id: " + updateEventRequest.getLocationId()));
            eventEntity.setLocation(location);
        }

        eventRepository.save(eventEntity);
    }
}
