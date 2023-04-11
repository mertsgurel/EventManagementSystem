package com.sukretgurel.eventmanagementsystem.service;

import com.sukretgurel.eventmanagementsystem.entity.Event;
import com.sukretgurel.eventmanagementsystem.entity.User;

public interface EventResolver {
    User getUser(Event event);
}
