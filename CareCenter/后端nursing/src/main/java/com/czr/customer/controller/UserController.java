package com.czr.customer.controller;

import com.czr.customer.model.User;
import com.czr.customer.service.UserService;
import com.github.pagehelper.PageInfo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/selectAll")
	public List<User> selectAll(){
		return userService.selectAll();
	}

	//获取Json类型数据，包含username和password
	@RequestMapping("/login")
	public String login(@RequestBody Map<String, Object> map){
		System.out.println("[login]" + map.get("username").toString() + ":" + map.get("password").toString());
		return userService.login(map.get("username").toString(), map.get("password").toString());
	}

	//获取id，返回nickname
	@RequestMapping("/getNickname/{id}")
	public String getNickname(@PathVariable Integer id){
		System.out.println(userService.selectByPrimaryKey(id).toString());
		return userService.selectByPrimaryKey(id).getNickname();
	}

	//获取Json类型user
	@RequestMapping("/insert")
	public boolean insert(@RequestBody User user){
		System.out.println("[add]" + user.getUsername());
		System.out.println(user.toString());
		return userService.add(user);
	}

	//通过user属性删除符合条件的user（可批量删除）
	@RequestMapping("/delete")
	public boolean delete(@RequestBody User user){
		System.out.println("[del]" + user.toString());
		return userService.delete(user);
	}

	//通过id找到该数据并覆盖
	@RequestMapping("/update")
	public boolean update(@RequestBody User user){
		System.out.println("[update]" + user.getUsername());
		return userService.update(user);
	}

	//获取json类型的user类，根据该user类特性，并返回user列表
	@RequestMapping("/search/{page}")
	PageInfo<User> search(@PathVariable Integer page, @RequestBody User user){
		return userService.search(page, user);
	}
}
