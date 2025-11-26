package com.jvt.jvtassistant.dto.request;


import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskCreateRequest {
    @NotBlank
    private String title;

    private String description;

    @NotNull
    private String category; // WORKOUT, DIET, STUDY, CODING, OTHER

    @NotNull
    private LocalDate date;
}
