package com.czr.customer.service;


import com.czr.customer.model.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

	String login(String username, String password);

	boolean add(User user);

	boolean delete(User user);

	boolean update(User user);

	PageInfo<User> search(Integer page, User user);

	User selectByPrimaryKey(Integer id);

	List<User> selectAll();
}
