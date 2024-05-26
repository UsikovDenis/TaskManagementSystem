package ru.usikov.taskmanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.usikov.taskmanagementsystem.entities.task.Task;
import ru.usikov.taskmanagementsystem.entities.user.User;
import ru.usikov.taskmanagementsystem.repository.UserRepository;
import ru.usikov.taskmanagementsystem.web.ApiMessageConstants;
import ru.usikov.taskmanagementsystem.web.dto.user.UserCreateRequest;
import ru.usikov.taskmanagementsystem.web.dto.user.UserDto;
import ru.usikov.taskmanagementsystem.web.errors.NotFoundException;
import ru.usikov.taskmanagementsystem.web.mapper.UserMapper;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public boolean isTaskOwner(UUID userId, UUID taskId) {
        User user = findById(userId);

        return user.getAuthorTasks().stream()
                .anyMatch(task -> task.getId().equals(taskId));
    }

    @Transactional
    public User findById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ApiMessageConstants.NOT_FOUND_USER));
    }

    @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(ApiMessageConstants.NOT_FOUND_USER));
    }

    @Transactional
    public UserDto getByUsername(String username) {
        return userMapper.toDto(findByUsername(username));
    }

    @Transactional
    public UserDto create(UserCreateRequest userCreateRequest) {
        User user = userMapper.toEntity(userCreateRequest);
        user.setPasswordHash(userCreateRequest.getPasswordHash());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Transactional
    public UserDto changePassword(String username, String newPasswordHash) {
        User user = findByUsername(username);
        user.setPasswordHash(newPasswordHash);
        return userMapper.toDto(user);
    }

}
