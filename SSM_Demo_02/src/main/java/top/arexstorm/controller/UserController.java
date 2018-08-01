package top.arexstorm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.arexstorm.annotation.HeaderRequire;
import top.arexstorm.annotation.IgnorerRights;
import top.arexstorm.annotation.ParamRequire;
import top.arexstorm.entity.User;
import top.arexstorm.response.AppResponse;
import top.arexstorm.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@IgnorerRights
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public AppResponse findUser(@PathVariable(value = "id") Long id, HttpServletRequest req) {
		User user = userService.findById(id);
		return AppResponse.okData(user);
	}

	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public AppResponse findUserList(@ParamRequire String keywords, HttpServletRequest req) {
		List<User> list = userService.findUserList(keywords);
		return AppResponse.okList(list);
	}

	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public AppResponse deleteUser(@HeaderRequire String id, HttpServletRequest req) {
		Integer result = userService.deleteUser(id);
		return AppResponse.okData(result);
	}
}
