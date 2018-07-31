package top.arexstorm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.arexstorm.entity.User;
import top.arexstorm.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-context.xml")
public class UserServiceImplTest {

	@Autowired
	private UserService userService;

	@Test
	public void findById() throws Exception {
		Long id = 1L;
		User user = userService.findById(id);
		System.err.println(user);
	}

	@Test
	public void saveUser() {
		User user = new User();
		user.setUsername("xiebo");
		user.setInterests("game");
		user.setAge(20);
		Integer result = null;
		try {
			result = userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println(result);
	}
}