package com.sukretgurel.eventmanagementsystem.service;

import com.sukretgurel.eventmanagementsystem.entity.User;

public interface UserMutationService {
    User createUser(String name, String email, String password);
}

