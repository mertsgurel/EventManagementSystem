package com.sukretgurel.eventmanagementsystem.service;

import com.sukretgurel.eventmanagementsystem.entity.Event;

import java.util.List;

public interface EventQueryService {
    Iterable<Event> findAllEvents();

    List<Event> findAllEventsPaged(int page, int limit);

    Integer countEvents();

    Event findEventById(int eventId);

}
