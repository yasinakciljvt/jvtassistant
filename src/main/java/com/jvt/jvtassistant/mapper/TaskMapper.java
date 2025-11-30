package com.jvt.jvtassistant.mapper;

import com.jvt.jvtassistant.dto.request.TaskCreateRequest;
import com.jvt.jvtassistant.dto.request.TaskUpdateDto;
import com.jvt.jvtassistant.dto.response.TaskResponse;
import com.jvt.jvtassistant.entity.Status;
import com.jvt.jvtassistant.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    /**
     * Task entity -> TaskResponse DTO dönüşümü
     * Servislerde tekrar yazmaya gerek yok
     */
    public TaskResponse toResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .category(task.getCategory())
                .status(task.getStatus())
                .date(task.getDate())
                .createdAt(task.getCreatedAt())
                .build();
    }

    /**
     * TaskCreateRequest -> Task entity dönüşümü
     * Servis içinde kullanıcıyı set etmek gerekir
     */
    public Task toEntity(TaskCreateRequest request, com.jvt.jvtassistant.entity.User user) {
        return Task.builder()
                .user(user)
                .title(request.getTitle())
                .description(request.getDescription())
                .category(request.getCategory())
                .status(Status.TODO) // yeni task TODO ile başlar
                .date(request.getDate())
                .build();
    }

    /**
     * Task güncelleme
     * TaskUpdateDto içindeki alanları entity'ye uygular
     */
    public void updateEntity(Task task, TaskUpdateDto dto) {
        if(dto.getTitle() != null) task.setTitle(dto.getTitle());
        if(dto.getDescription() != null) task.setDescription(dto.getDescription());
        if(dto.getCategory() != null) task.setCategory(dto.getCategory());
        if(dto.getDate() != null) task.setDate(dto.getDate());
        if(dto.getStatus() != null) task.setStatus(dto.getStatus());
    }
}
