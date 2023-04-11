package com.sukretgurel.eventmanagementsystem.controller;

import com.sukretgurel.eventmanagementsystem.entity.User;
import com.sukretgurel.eventmanagementsystem.service.serviceImpl.UserQueryServiceImpl;
import com.sukretgurel.eventmanagementsystem.service.serviceImpl.UserMutationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserQueryServiceImpl userQueryService;
    private final UserMutationServiceImpl userMutationService;

    @QueryMapping
    public List<User> findAllUsers() {
        List<User> result = new ArrayList<>();
        userQueryService.findAllUsers().forEach(result::add);
        return result;
    }

    @QueryMapping
    public List<User> findAllUsersPaged(@Argument int page, @Argument int limit) {
        return userQueryService.findAllUsersPaged(page, limit);
    }

    @QueryMapping
    public int countUsers() {
        return userQueryService.countUsers();
    }

    @QueryMapping
    public User findUserById(@Argument int userId) {
        return userQueryService.findUserById(userId);
    }

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email, @Argument String password) {
        return userMutationService.createUser(name, email, password);
    }
}