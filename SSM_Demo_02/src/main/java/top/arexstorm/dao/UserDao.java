package top.arexstorm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.arexstorm.entity.User;

import java.time.temporal.ValueRange;
import java.util.List;

@Mapper
public interface UserDao {

	User findById(Long id);

	Integer saveUser(User user);

	List<User> findUserList(@Param(value = "keywords") String keywords);

	Integer deleteUser(@Param(value = "id") String id);
}
