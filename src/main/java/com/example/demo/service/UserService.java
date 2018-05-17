package com.example.demo.service;

import com.example.demo.domain.dto.Result;
import com.example.demo.domain.entity.User;
import org.springframework.http.ResponseEntity;

/**
 * @author zhaoyiwei 2018/5/10 14:55
 */

public interface UserService {
    User getUserById(Long id);

    User addUser(User user);

    ResponseEntity<Result> login(String phone);
}
