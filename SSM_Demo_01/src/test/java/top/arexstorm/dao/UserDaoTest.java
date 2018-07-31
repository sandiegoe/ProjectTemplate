package top.arexstorm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.arexstorm.entity.User;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-context.xml")
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void findById() {
		Long id = 1L;
		User user = userDao.findById(id);
		System.err.println(user);
	}
}