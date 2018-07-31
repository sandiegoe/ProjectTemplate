package top.arexstorm.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.arexstorm.dao.UserDao;
import top.arexstorm.entity.User;
import top.arexstorm.service.UserService;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findById(Long id) throws Exception {
		return userDao.findById(id);
	}

	@Override
	public Integer saveUser(User user) throws Exception {
		if (user == null || StringUtils.isBlank(user.getUsername())) {
			throw new Exception("user is null or username is blank....");
		}
		Integer result = userDao.saveUser(user);
//		int a = 1 / 0; // test service transaction....
		return result;
	}
}
