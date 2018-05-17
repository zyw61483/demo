package com.example.demo.web;

import com.example.demo.domain.demo_enum.Role;
import com.example.demo.domain.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "user/getUserById", method = RequestMethod.POST)
	public ResponseEntity getUserById (Long id){
		User u = userService.getUserById(id);
		return ResponseEntity.ok(u);
	}

	@RequestMapping(value = "user/add", method = RequestMethod.POST)
	public ResponseEntity addUser (@RequestParam(name = "phone") String phone){
		User user = new User();
		user.setPhone(phone);
		user.setName(phone);
		user.setCreatTime(new Date());
		user.setRole(Role.CUSTOMER);
		user = userService.addUser(user);
		return ResponseEntity.ok(user);
	}

	@ApiIgnore//使用该注解忽略这个API
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String  jsonTest() {
		return " hi you!";
	}
}
