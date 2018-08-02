package top.arexstorm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

@Api(description = "用户操作Controller", value = "用户Controller", tags = {"用户"})
@RequestMapping(value = "/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "获取用户详情", notes = "根据用户id获取user信息")
	@IgnorerRights
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public AppResponse findUser(@PathVariable(value = "id") @ApiParam(name = "id", value = "用户id", required = true) Long id, HttpServletRequest req) {
		User user = userService.findById(id);
		return AppResponse.okData(user);
	}

	@ApiOperation(value = "获取用户列表", notes = "根据keywords来获取用户信息")
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public AppResponse findUserList(@ParamRequire @ApiParam(name = "keywords", value = "关键字", required = true) String keywords, HttpServletRequest req) {
		List<User> list = userService.findUserList(keywords);
		return AppResponse.okList(list);
	}

	@ApiOperation(value = "删除用户接口", notes = "根据用户id来删除用户")
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public AppResponse deleteUser(@HeaderRequire @ApiParam(name = "id", value = "用户id, 放在请求头中", required = true) String id, HttpServletRequest req) {
		Integer result = userService.deleteUser(id);
		return AppResponse.okData(result);
	}
}
