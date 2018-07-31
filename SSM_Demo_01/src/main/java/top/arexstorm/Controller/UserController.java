package top.arexstorm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.arexstorm.entity.User;
import top.arexstorm.service.UserService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public User findUser(@PathVariable(value = "id", required = true) Long id, HttpServletResponse resp) throws Exception {
		User user = userService.findById(id);
		return user;
	}
}
