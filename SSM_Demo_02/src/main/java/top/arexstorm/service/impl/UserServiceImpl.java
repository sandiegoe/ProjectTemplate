package top.arexstorm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.arexstorm.dao.UserDao;
import top.arexstorm.entity.User;
import top.arexstorm.exception.BizException;
import top.arexstorm.service.UserService;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findById(Long id) throws BizException {
		return userDao.findById(id);
	}

	@Override
	public Integer saveUser(User user) throws BizException {
		return userDao.saveUser(user);
	}

	@Override
	public List<User> findUserList(String keywords) throws BizException {
		return userDao.findUserList(keywords);
	}

	@Override
	public Integer deleteUser(String id) throws BizException {
		return userDao.deleteUser(id);
	}
}
