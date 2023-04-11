package com.sukretgurel.eventmanagementsystem.service.serviceImpl;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sukretgurel.eventmanagementsystem.entity.User;
import com.sukretgurel.eventmanagementsystem.service.UserMutationService;
import com.sukretgurel.eventmanagementsystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@AllArgsConstructor
public class UserMutationServiceImpl implements UserMutationService, GraphQLMutationResolver {

    private final UserRepository userRepository;

    @Override
    public User createUser(String name, String email, String password) {
        User user = User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();

        User savedUser = userRepository.save(user);
        return savedUser;
    }
}