package top.arexstorm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.arexstorm.annotation.HeaderRequire;
import top.arexstorm.annotation.ParamRequire;
import top.arexstorm.entity.User;
import top.arexstorm.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public List<User> findUserList(@ParamRequire String keywords, HttpServletRequest req) {
		List<User> list = userService.findUserList(keywords);
		return list;
	}

	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> deleteUser(@HeaderRequire String id, HttpServletRequest req) {
		Integer result = userService.deleteUser(id);
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		return map;
	}
}
