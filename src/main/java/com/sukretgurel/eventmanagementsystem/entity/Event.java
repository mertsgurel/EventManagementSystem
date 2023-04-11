package com.sukretgurel.eventmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventId;
    private String eventName;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private int quota;
    private int numberOfParticipants;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User userDetails;
}