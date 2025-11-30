package com.jvt.jvtassistant.dto.request;

import com.jvt.jvtassistant.entity.Category;
import com.jvt.jvtassistant.entity.Status;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskUpdateDto {
    private String title;
    private String description;
    private Category category;
    private LocalDate date;
    private Status status;
}
