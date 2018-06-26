package cn.service.impl;

import cn.dao.UserDao;
import cn.dao.impl.UserDaoimp;
import cn.entity.Grade;
import cn.entity.User;
import cn.service.UserService;

/*
 * @ Copyright (c) Create by JASON  Date:2018-02-10  All rights reserved.
 *
 * @ class description：操作用户
 *
 */
public class UserServiceimp implements UserService{
	UserDao userDao = null;
	
	public UserServiceimp(){
		userDao = new UserDaoimp();
	}

	@Override
	//查找用户
	public boolean findUser(User user) {
		return userDao.findUser(user);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}
	

}


