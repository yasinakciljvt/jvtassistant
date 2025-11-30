package com.jvt.jvtassistant.controller;

import com.jvt.jvtassistant.dto.request.UserRegisterRequest;
import com.jvt.jvtassistant.dto.response.UserResponse;
import com.jvt.jvtassistant.entity.User;
import com.jvt.jvtassistant.mapper.UserMapper;
import com.jvt.jvtassistant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    /**
     * Yeni kullanıcı kaydı
     */
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRegisterRequest request) {
        UserResponse user = userService.registerUser(request); // userService direkt entity dönüyorsa mapper kullanılacak
        return ResponseEntity.ok(user); // registerUser metodu artık direkt UserResponse döndürüyor
    }

    /**
     * Kullanıcıyı ID ile bulma
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID id) {
        var user = userService.getUserById(id); // entity
        var response = userMapper.toResponse(user); // mapper ile DTO
        return ResponseEntity.ok(response);
    }
}
