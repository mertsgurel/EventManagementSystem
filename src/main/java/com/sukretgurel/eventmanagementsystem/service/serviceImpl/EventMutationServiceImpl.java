package com.sukretgurel.eventmanagementsystem.service.serviceImpl;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sukretgurel.eventmanagementsystem.entity.Event;
import com.sukretgurel.eventmanagementsystem.entity.User;
import com.sukretgurel.eventmanagementsystem.repository.EventRepository;
import com.sukretgurel.eventmanagementsystem.repository.UserRepository;
import com.sukretgurel.eventmanagementsystem.service.EventMutationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
@AllArgsConstructor
public class EventMutationServiceImpl implements EventMutationService, GraphQLMutationResolver {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public Event createEvent(String eventName, OffsetDateTime startDate, OffsetDateTime endDate, int quota, int numberOfParticipants, int userId) {
        User user = userRepository.findByUserId(userId).orElse(null);
        System.out.println("User: " + user);

        Event event = Event.builder()
                .eventName(eventName)
                .startDate(startDate)
                .endDate(endDate)
                .quota(quota)
                .numberOfParticipants(numberOfParticipants)
                .userDetails(user)
                .build();
        Event savedEvent = eventRepository.save(event);
        return savedEvent;
    }

    @Override
    public Event updateEvent(int eventId, String eventName, OffsetDateTime startDate, OffsetDateTime endDate, int quota, int numberOfParticipants) {
        Event existingEvent = eventRepository.findByEventId(eventId).orElseThrow(()-> new RuntimeException("Not found"));
        existingEvent.setEventName(eventName);
        existingEvent.setStartDate(startDate);
        existingEvent.setEndDate(endDate);
        existingEvent.setQuota(quota);
        existingEvent.setNumberOfParticipants(numberOfParticipants);

        Event updatedEvent = eventRepository.save(existingEvent);
        return updatedEvent;
    }

    @Override
    public boolean deleteEvent(int id) {
        eventRepository.findByEventId(id).orElseThrow(()-> new RuntimeException("Not found"));
        eventRepository.deleteById(id);
        return true;
    }
}
