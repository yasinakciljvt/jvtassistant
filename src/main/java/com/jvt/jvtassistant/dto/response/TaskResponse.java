package com.jvt.jvtassistant.dto.response;


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
    private String category;
    private String status;
    private LocalDate date;
    private LocalDateTime createdAt;
}
