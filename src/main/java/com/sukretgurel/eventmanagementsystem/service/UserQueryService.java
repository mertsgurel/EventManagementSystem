package com.sukretgurel.eventmanagementsystem.service;

import com.sukretgurel.eventmanagementsystem.entity.User;

import java.util.List;

public interface UserQueryService {
    Iterable<User> findAllUsers();

    List<User> findAllUsersPaged(int page, int limit);
    Integer countUsers();

    User findUserById(int userId);

}