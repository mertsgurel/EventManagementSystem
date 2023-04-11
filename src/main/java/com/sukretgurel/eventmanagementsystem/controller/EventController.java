package com.sukretgurel.eventmanagementsystem.controller;

import com.sukretgurel.eventmanagementsystem.entity.Event;
import com.sukretgurel.eventmanagementsystem.entity.User;
import com.sukretgurel.eventmanagementsystem.service.serviceImpl.EventMutationServiceImpl;
import com.sukretgurel.eventmanagementsystem.service.serviceImpl.EventQueryServiceImpl;
import com.sukretgurel.eventmanagementsystem.service.serviceImpl.EventResolverImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequiredArgsConstructor
public class EventController {
    private final EventQueryServiceImpl eventQueryService;
    private final EventMutationServiceImpl eventMutationService;
    private final EventResolverImpl eventResolver;

    @QueryMapping
    public List<Event> findAllEvents() {
        List<Event> events = new ArrayList<>();
        eventQueryService.findAllEvents().forEach(events::add);
        return events;
    }

    @QueryMapping
    public List<Event> findAllEventsPaged(@Argument int page, @Argument int limit) {
        return eventQueryService.findAllEventsPaged(page, limit);
    }

    @QueryMapping
    public int countEvents() {
        return eventQueryService.countEvents();
    }

    @QueryMapping
    public Event findEventById(@Argument int eventId) {
        return eventQueryService.findEventById(eventId);
    }
    @SchemaMapping
    public User user(Event event) {
        return eventResolver.getUser(event);
    }

    @MutationMapping
    public Event createEvent(@Argument String eventName, @Argument OffsetDateTime startDate, @Argument OffsetDateTime endDate, @Argument int quota, @Argument int numberOfParticipants, @Argument int userId) {
        return eventMutationService.createEvent(eventName, startDate,endDate,quota,numberOfParticipants, userId);
    }

    @MutationMapping
    public Event updateEvent(@Argument int eventId, @Argument String eventName, @Argument OffsetDateTime startDate, @Argument OffsetDateTime endDate, @Argument int quota, @Argument int numberOfParticipants) {
        return eventMutationService.updateEvent(eventId, eventName, startDate,endDate,quota,numberOfParticipants);
    }

    @MutationMapping
    public boolean deleteEvent(@Argument int eventId) {
        return eventMutationService.deleteEvent(eventId);
    }
}
