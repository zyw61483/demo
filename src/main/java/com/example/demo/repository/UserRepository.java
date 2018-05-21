package com.example.demo.repository;

import com.example.demo.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhaoyiwei 2018/5/10 15:38
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserById(Long id);

    User findUserByPhoneAndPwd(String phone, String pwd);

    User findUserByOpenId(String openId);
}
