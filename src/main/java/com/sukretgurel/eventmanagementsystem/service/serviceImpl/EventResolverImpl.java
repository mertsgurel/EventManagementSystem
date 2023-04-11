package com.sukretgurel.eventmanagementsystem.service.serviceImpl;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sukretgurel.eventmanagementsystem.entity.Event;
import com.sukretgurel.eventmanagementsystem.entity.User;
import com.sukretgurel.eventmanagementsystem.repository.UserRepository;
import com.sukretgurel.eventmanagementsystem.service.EventResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventResolverImpl implements EventResolver, GraphQLResolver<Event> {
    private final UserRepository userRepository;

    @Override
    public User getUser(Event event) {
        return userRepository.findById(event.getUserDetails().getUserId())
                .orElseThrow(()-> new RuntimeException("User needed"));
    }
}
