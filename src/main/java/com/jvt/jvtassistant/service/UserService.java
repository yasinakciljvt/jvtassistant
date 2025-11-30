package com.jvt.jvtassistant.service;

import com.jvt.jvtassistant.dto.request.UserRegisterRequest;
import com.jvt.jvtassistant.dto.response.UserResponse;
import com.jvt.jvtassistant.entity.User;

import java.util.UUID;

public interface UserService {

    /**
     * Yeni kullanıcı kaydı oluşturur
     * @param request frontend’den gelen kullanıcı bilgileri
     * @return kayıt sonrası UserResponse DTO
     */
    UserResponse registerUser(UserRegisterRequest request);

    /**
     * Kullanıcıyı ID ile bulur
     * TaskService veya başka servislerde kullanıcıya erişmek için kullanılır
     */
    User getUserById(UUID userId);
}
