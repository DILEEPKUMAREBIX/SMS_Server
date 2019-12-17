package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.User;
import com.sms.service.UserService;

@RestController
@RequestMapping("/login")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> listUser() {
		return userService.findAll();
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User findOne(@PathVariable long id) {
		return userService.findOne(id);
	}

	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	public User findOneWithUserName(@PathVariable String username) {
		return userService.findOneWithUserName(username);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable long id, @RequestBody User user) {
		user.setId(id);
		return userService.save(user);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Long id) {
		userService.delete(id);
	}

}
