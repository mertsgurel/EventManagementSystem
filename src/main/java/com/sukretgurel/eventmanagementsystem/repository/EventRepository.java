package com.sukretgurel.eventmanagementsystem.repository;

import com.sukretgurel.eventmanagementsystem.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
    Optional<Event> findByEventId(int eventId);
}
