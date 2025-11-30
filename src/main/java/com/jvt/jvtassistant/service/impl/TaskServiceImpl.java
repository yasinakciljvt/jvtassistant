package com.jvt.jvtassistant.service.impl;

import com.jvt.jvtassistant.dto.request.TaskCreateRequest;
import com.jvt.jvtassistant.dto.request.TaskUpdateDto;
import com.jvt.jvtassistant.dto.response.TaskResponse;
import com.jvt.jvtassistant.entity.Task;
import com.jvt.jvtassistant.entity.User;
import com.jvt.jvtassistant.mapper.TaskMapper;
import com.jvt.jvtassistant.repository.TaskRepository;
import com.jvt.jvtassistant.repository.UserRepository;
import com.jvt.jvtassistant.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper; // mapper inject edildi

    @Override
    public TaskResponse createTask(UUID userId, TaskCreateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = taskMapper.toEntity(request, user);
        task.setCreatedAt(LocalDateTime.now());

        Task saved = taskRepository.save(task);
        return taskMapper.toResponse(saved);
    }

    @Override
    public List<TaskResponse> getUserTasks(UUID userId) {
        return taskRepository.findByUserId(userId)
                .stream()
                .map(taskMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponse updateTask(UUID taskId, TaskUpdateDto dto) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        taskMapper.updateEntity(task, dto);

        Task updated = taskRepository.save(task);
        return taskMapper.toResponse(updated);
    }

    @Override
    public void deleteTask(UUID taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }
}
