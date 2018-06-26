package cn.dao;

import java.util.List;

import cn.entity.User;

public interface ManagerDao {
	
		public boolean delUser(int id);
	    public User queryUserById(int id);
	    public List<User> listAllUser();
	    public List<User> queryUserByName(String name);
}
