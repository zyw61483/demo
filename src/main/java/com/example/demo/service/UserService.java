package com.example.demo.service;

import com.example.demo.domain.entity.User;

/**
 * @author zhaoyiwei 2018/5/10 14:55
 */

public interface UserService {
    User getUserById(Long id);

    User addUser(User user);
}
