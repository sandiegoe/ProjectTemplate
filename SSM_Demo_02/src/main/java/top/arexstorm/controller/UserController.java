package top.arexstorm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.arexstorm.entity.User;
import top.arexstorm.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public User findUser(@PathVariable(value = "id") Long id, HttpServletRequest req) throws Exception {
		User user = userService.findById(id);
		return user;
	}

}
