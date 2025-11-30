package com.jvt.jvtassistant.mapper;

import com.jvt.jvtassistant.dto.request.UserRegisterRequest;
import com.jvt.jvtassistant.dto.response.UserResponse;
import com.jvt.jvtassistant.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User toEntity(UserRegisterRequest request, String encodedPassword) {
        return User.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(encodedPassword)
                .build();
    }

    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }
    public UserResponse mapToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }
}

