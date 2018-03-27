package com.jxliu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jxliu.ssm.mapper.UserMapper;
import com.jxliu.ssm.pojo.User;
import com.jxliu.ssm.pojo.UserExample;
import com.jxliu.ssm.pojo.UserExample.Criteria;
import com.jxliu.ssm.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	/**
	 * 查询所有用户信息
	 */
	@Override
	public List<User> queryUserList() {
		UserExample example = new UserExample();
		List<User> userList = userMapper.selectByExample(example);
		return userList;
	}
	
	/**
	 * 查询所有用户数量
	 */
	@Override
	public int queryUserListCount() {
		UserExample example = new UserExample();
		int count = userMapper.countByExample(example);
		return count;
	}
	
	/**
	 * 保存用户信息
	 */
	@Override
	public void saveUser(User user) {
		try {
			userMapper.insert(user);
//			int i = 1/0;
			//spring的事务控制，控制的是runtimeexception时期的异常，如果是由于sql错误，导致的异常，并不属于事务控制的范围内，所以并不会事务回滚！
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
	}

	/**
	 * 修改用户信息
	 */
	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKey(user); 
	}

	/**
	 * 通过用户id查询用户信息
	 */
	@Override
	public User selectUserById(User user) {
		User u = userMapper.selectByPrimaryKey(user.getId());
		return u;
	}

	/**
	 * 删除用户信息
	 */
	@Override
	public void deleteUser(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}
	
}
