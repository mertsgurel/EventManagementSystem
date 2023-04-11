package com.sukretgurel.eventmanagementsystem.service.serviceImpl;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sukretgurel.eventmanagementsystem.entity.Event;
import com.sukretgurel.eventmanagementsystem.repository.EventRepository;
import com.sukretgurel.eventmanagementsystem.service.EventQueryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class EventQueryServiceImpl implements EventQueryService, GraphQLQueryResolver {
    private final EventRepository eventRepository;

    @Override
    public Iterable<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> findAllEventsPaged(int page, int limit) {
        if (page > 0) page -= 1;
        Pageable pageable = PageRequest.of(page, limit);
        Page<Event> pagedEvent = eventRepository.findAll(pageable);
        return pagedEvent.getContent();
    }

    @Override
    public Integer countEvents() {
        return Math.toIntExact(eventRepository.count());
    }

    @Override
    public Event findEventById(int eventId) {
        return eventRepository.findById(eventId).orElseThrow(()-> new RuntimeException("Event does not exist"));
    }

}