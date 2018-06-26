package cn.dao;

import java.util.List;

import cn.entity.User;


public interface UserDao {
	
	//查找用户
	public boolean findUser(User user);
	public boolean addUser(User user);
    public boolean updateUser(User user);
}


