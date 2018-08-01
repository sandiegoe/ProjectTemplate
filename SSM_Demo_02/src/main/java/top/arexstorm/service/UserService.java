package top.arexstorm.service;

import top.arexstorm.entity.User;

import java.util.List;

public interface UserService {

	User findById(Long id) throws Exception;

	Integer saveUser(User user) throws Exception;

	List<User> findUserList(String keywords);

	Integer deleteUser(String id);
}
