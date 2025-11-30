package com.jvt.jvtassistant.repository;


import com.jvt.jvtassistant.entity.Status;
import com.jvt.jvtassistant.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    List<Task> findAllByUserIdAndDate(UUID userId, LocalDate date);

    List<Task> findAllByUserId(UUID userId);
    Optional<Task> findByUserId(UUID userId);

    List<Task> findByUserIdAndStatus(UUID userId, Status status);

}
