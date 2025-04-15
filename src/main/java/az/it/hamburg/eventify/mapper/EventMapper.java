package az.it.hamburg.eventify.mapper;

import az.it.hamburg.eventify.dao.entity.EventEntity;
import az.it.hamburg.eventify.dao.entity.LocationEntity;
import az.it.hamburg.eventify.model.request.create.CreateEventRequest;
import az.it.hamburg.eventify.model.response.EventResponse;

public enum EventMapper {
    EVENT_MAPPER;

    public EventEntity requestToEntity(CreateEventRequest createEventRequest, LocationEntity location) {
        return EventEntity.builder()
                .title(createEventRequest.getTitle())
                .description(createEventRequest.getDescription())
                .eventDate(createEventRequest.getEventDate())
                .eventType(createEventRequest.getEventType())
                .price(createEventRequest.getPrice())
                .location(location)
                .build();
    }

    public static EventResponse entityToResponse(EventEntity entity) {
        return EventResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .location(entity.getLocation() != null ? entity.getLocation().getName() : null)
                .eventStatus(entity.getEventStatus())
                .eventType(entity.getEventType())
                .eventDate(entity.getEventDate())
                .price(entity.getPrice())
                .build();
    }
}
