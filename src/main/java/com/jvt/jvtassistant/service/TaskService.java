package com.jvt.jvtassistant.service;

import com.jvt.jvtassistant.dto.request.TaskCreateRequest;
import com.jvt.jvtassistant.dto.request.TaskUpdateDto;
import com.jvt.jvtassistant.dto.response.TaskResponse;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    TaskResponse createTask(UUID userId, TaskCreateRequest request);

    List<TaskResponse> getUserTasks(UUID userId);

    TaskResponse updateTask(UUID taskId, TaskUpdateDto dto);

    void deleteTask(UUID taskId);
}
