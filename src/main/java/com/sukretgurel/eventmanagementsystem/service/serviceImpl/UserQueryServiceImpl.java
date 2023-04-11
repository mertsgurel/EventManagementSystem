package com.sukretgurel.eventmanagementsystem.service.serviceImpl;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sukretgurel.eventmanagementsystem.entity.User;
import com.sukretgurel.eventmanagementsystem.repository.UserRepository;
import com.sukretgurel.eventmanagementsystem.service.UserQueryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class UserQueryServiceImpl implements UserQueryService, GraphQLQueryResolver {
    private final UserRepository userRepository;
    @Override
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllUsersPaged(int page, int limit) {
        if (page > 0) page -= 1;
        Pageable pageable = PageRequest.of(page, limit);
        Page<User> pagedUser = userRepository.findAll(pageable);
        return pagedUser.getContent();
    }

    @Override
    public Integer countUsers() {
        return Math.toIntExact(userRepository.count());
    }

    @Override
    public User findUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User does not exist"));
    }


}
