package top.arexstorm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.arexstorm.entity.User;

import java.time.temporal.ValueRange;

//@Repository(value = "userDao")
@Mapper
public interface UserDao {

	User findById(Long id);

	Integer saveUser(User user);
}
