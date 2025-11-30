package com.jvt.jvtassistant.controller;

import com.jvt.jvtassistant.dto.request.TaskCreateRequest;
import com.jvt.jvtassistant.dto.request.TaskUpdateDto;
import com.jvt.jvtassistant.dto.response.TaskResponse;
import com.jvt.jvtassistant.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<TaskResponse> createTask(
            @PathVariable UUID userId,
            @RequestBody TaskCreateRequest request
    ) {
        TaskResponse response = taskService.createTask(userId, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskResponse>> getUserTasks(@PathVariable UUID userId) {
        List<TaskResponse> tasks = taskService.getUserTasks(userId);
        if (tasks.isEmpty()) {
            tasks = Collections.emptyList();
        }
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskResponse> updateTask(
            @PathVariable UUID taskId,
            @RequestBody TaskUpdateDto dto
    ) {
        TaskResponse updated = taskService.updateTask(taskId, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
