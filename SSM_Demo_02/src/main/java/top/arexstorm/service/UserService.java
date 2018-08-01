package top.arexstorm.service;

import top.arexstorm.entity.User;

public interface UserService {

	User findById(Long id) throws Exception;

	Integer saveUser(User user) throws Exception;
}
