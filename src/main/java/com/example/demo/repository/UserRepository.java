package com.example.demo.repository;

import com.example.demo.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhaoyiwei 2018/5/10 15:38
 */
public interface UserRepository extends CrudRepository<User, Long> {
    public User findUserById(Long id);

    public User findUserByPhoneAndPwd(String phone,String pwd);

}
