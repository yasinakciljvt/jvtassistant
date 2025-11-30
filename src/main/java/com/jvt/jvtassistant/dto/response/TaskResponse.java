package com.jvt.jvtassistant.dto.response;


import com.jvt.jvtassistant.entity.Category;
import com.jvt.jvtassistant.entity.Status;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponse {
    private UUID id;
    private String title;
    private String description;
    private Category category;
    private Status status;
    private LocalDate date;
    private LocalDateTime createdAt;
}
