package top.arexstorm.service;

import top.arexstorm.entity.User;
import top.arexstorm.exception.BizException;

import java.net.BindException;
import java.util.List;

public interface UserService {

	User findById(Long id) throws BizException;

	Integer saveUser(User user) throws BizException;

	List<User> findUserList(String keywords) throws BizException;

	Integer deleteUser(String id) throws BizException;
}
