package az.it.hamburg.eventify.mapper;

import az.it.hamburg.eventify.dao.entity.EventEntity;
import az.it.hamburg.eventify.dao.entity.TicketEntity;
import az.it.hamburg.eventify.dao.entity.UserEntity;
import az.it.hamburg.eventify.model.request.create.CreateTicketRequest;
import az.it.hamburg.eventify.model.response.EventResponse;
import az.it.hamburg.eventify.model.response.TicketResponse;


public enum TicketMapper {
    TICKET_MAPPER;

    public static TicketEntity requestToEntity(CreateTicketRequest request, UserEntity user, EventEntity event) {
        TicketEntity ticket = new TicketEntity();
        ticket.setSeatNumber(request.getSeatNumber());
        ticket.setUser(user);
        ticket.setEvent(event);
        return ticket;
    }

    public static TicketResponse entityToResponse(TicketEntity entity) {
        EventResponse eventResponse = EventMapper.entityToResponse(entity.getEvent());
        return TicketResponse.builder()
                .id(entity.getId())
                .seatNumber(entity.getSeatNumber())
                .price(entity.getPrice())
                .eventId(entity.getEvent().getId())
                .eventName(entity.getEvent().getEventType().name())
                .userId(entity.getUser().getId())
                .userName(entity.getUser().getName() + " " + entity.getUser().getSurname())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
