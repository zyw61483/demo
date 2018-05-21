package com.example.demo.service.impl;

import com.example.demo.domain.demo_enum.ResCodeEnum;
import com.example.demo.domain.dto.Result;
import com.example.demo.domain.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.EncryptUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author zhaoyiwei 2018/5/10 14:55
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User addUser(User user) {
        user.setCreatTime(new Date());
        user.setPwd(EncryptUtil.getEncString(user.getPhone(),EncryptUtil.KEY));
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<Result> login(String phone) {
        Result result = new Result();
        User user = userRepository.findUserByPhoneAndPwd(phone, EncryptUtil.getEncString(phone, EncryptUtil.KEY));
        if(user!=null){
            result.setResCode(ResCodeEnum.SUCCESS);
        }else{
            result.setResCode(ResCodeEnum.FAIL);
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Result> updateUser(User u) {
        Result result = new Result();
        try {
            User user = userRepository.findUserByOpenId(u.getOpenId());
            BeanUtils.copyProperties(u, user);
            userRepository.save(user);
            result.setResCode(ResCodeEnum.SUCCESS);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            result.setResCode(ResCodeEnum.FAIL);
            return ResponseEntity.ok(result);
        }
    }
}
