package com.czr.customer.service;

import com.czr.customer.mapper.UserMapper;
import com.czr.customer.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public String login(String username, String password) {
			User user1 = new User();
			user1.setUsername(username);
			List<User> users = userMapper.selectByElement(user1);
			if(users.size() == 0)
				return "1";//用户名错误
			if(users.get(0).getPassword().equals(password))
				return "0";//通过
			else
				return "2";//密码错误
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean add(User user) {
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		userMapper.insert(user);
		return true;
	}

	@Override
	public boolean delete(User user) {

		User _user = new User(user);
		List<User> user1 = userMapper.selectByElement(_user);
		if(0 <= user1.size())
		{
			System.out.println("delete:"+user1.get(0).getUsername());
			user1.get(0).setIsDeleted(1);
			userMapper.updateByPrimaryKey(user1.get(0));
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean update(User user) {
		user.setUpdateTime(new Date());
		userMapper.updateByPrimaryKey(user);
		return true;
	}

	@Override
	public PageInfo<User> search(Integer page, User user) {
		User user1 = new User(user);
		if(page == null) page = 1;
		//设置从第几页查询N条
		PageHelper.startPage(page, 10);
		//分页查询
		PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectByElement(user1));
		return pageInfo;
	}

	@Override
	public List<User> selectAll() {
		return userMapper.selectByElement(new User());
	}
}
