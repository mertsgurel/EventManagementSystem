package com.sukretgurel.eventmanagementsystem.service;

import com.sukretgurel.eventmanagementsystem.entity.Event;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public interface EventMutationService {
    Event createEvent(String eventName, OffsetDateTime startDate, OffsetDateTime endDate, int quota, int numberOfParticipants, int userId);

    Event updateEvent(int eventId, String eventName, OffsetDateTime startDate, OffsetDateTime endDate, int quota, int numberOfParticipants);

    boolean deleteEvent(int id);
}