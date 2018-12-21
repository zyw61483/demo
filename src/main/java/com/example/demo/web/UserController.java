package com.example.demo.web;

import com.example.demo.domain.enums.RoleEnum;
import com.example.demo.domain.dto.Result;
import com.example.demo.domain.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
@Slf4j
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "user/getUserById")
	public ResponseEntity getUserById (Long id){
		User u = userService.getUserById(id);
		return ResponseEntity.ok(u);
	}

	@RequestMapping(value = "user/add", method = RequestMethod.POST)
	public ResponseEntity addUser (@RequestParam(name = "phone") String phone){
		User user = new User();
		user.setPhone(phone);
		user.setPwd(phone);
		user.setName(phone);
		user.setCreatTime(new Date());
		user.setRole(RoleEnum.CUSTOMER);
		user = userService.addUser(user);
		return ResponseEntity.ok(user);
	}

    @RequestMapping(value = "user/update", method = RequestMethod.POST)
    public ResponseEntity updateUser (@RequestBody User user){
        return userService.updateUser(user);
    }

	@RequestMapping(value = "user/login")
    public ResponseEntity<Result> login(String phone){
	    return userService.login(phone);
    }

	@ApiIgnore//使用该注解忽略这个API
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String  jsonTest() {
		return " hi you!";
	}
}
