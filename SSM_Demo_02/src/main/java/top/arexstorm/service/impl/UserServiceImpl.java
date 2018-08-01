package top.arexstorm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.arexstorm.dao.UserDao;
import top.arexstorm.entity.User;
import top.arexstorm.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findById(Long id) throws Exception {
		return userDao.findById(id);
	}

	@Override
	public Integer saveUser(User user) throws Exception {
		return userDao.saveUser(user);
	}
}
