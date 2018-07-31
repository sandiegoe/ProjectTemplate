package top.arexstorm.dao;

import org.springframework.stereotype.Repository;
import top.arexstorm.entity.User;

@Repository(value = "userDao")
public interface UserDao {

	User findById(Long id);

	Integer saveUser(User user);
}
