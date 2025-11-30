package com.jvt.jvtassistant.dto.response;


import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private UUID id;
    private String userName;
    private String email;
    private LocalDateTime createdAt;
}
