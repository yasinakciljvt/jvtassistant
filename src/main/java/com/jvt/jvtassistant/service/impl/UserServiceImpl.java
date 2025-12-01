package com.jvt.jvtassistant.service.impl;

import com.jvt.jvtassistant.dto.request.UserRegisterRequest;
import com.jvt.jvtassistant.dto.response.UserResponse;
import com.jvt.jvtassistant.entity.User;
import com.jvt.jvtassistant.mapper.UserMapper;
import com.jvt.jvtassistant.repository.UserRepository;
import com.jvt.jvtassistant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import com.jvt.jvtassistant.errorhandler.UserAlreadyExistsException;
import com.jvt.jvtassistant.errorhandler.EmailAlreadyExistsException;
import com.jvt.jvtassistant.errorhandler.UserNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;



    @Override
    public UserResponse registerUser(UserRegisterRequest request) {
        if(userRepository.existsByUserName(request.getUserName())) {
            throw new UserAlreadyExistsException("Username already exists");
        }
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = User.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(request.getPassword()) // encode yok
                .createdAt(LocalDateTime.now())
                .build();

        User saved = userRepository.save(user);
        return userMapper.mapToResponse(saved);
    }

    @Override
    public User getUserById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }


}
