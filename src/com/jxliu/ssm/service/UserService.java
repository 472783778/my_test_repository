package com.jxliu.ssm.service;

import java.util.List;

import com.jxliu.ssm.pojo.User;

public interface UserService {
	public List<User> queryUserList();
	public int queryUserListCount();
	public void saveUser(User user);
	public void updateUser(User user);
	public User selectUserById(User user);
	public void deleteUser(Integer id);
}
