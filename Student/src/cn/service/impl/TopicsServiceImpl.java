package cn.service.impl;

import java.sql.SQLException;
import java.util.List;


import cn.dao.TopicsDao;
import cn.dao.impl.TopicsDaoImpl;
import cn.entity.Topic;
import cn.service.TopicsService;



public class TopicsServiceImpl implements TopicsService{
	TopicsDao topicsDao = new TopicsDaoImpl();
	// 获取所有主题
	public List<Topic> findAllTopics() throws SQLException {
		// TODO Auto-generated method stub
		return topicsDao.getAllTopics();
	}
	// 更新所有主题
	public int updateTopic(Topic topic) throws SQLException {
		// TODO Auto-generated method stub
		return topicsDao.updateTopic(topic);
	}
	// 根据名字查找主题
	public boolean findTopicByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return topicsDao.findTopicByName(name);
	}
	// 添加主题
	public int addTopic(Topic topic) throws SQLException {
		// TODO Auto-generated method stub
		return topicsDao.addTopic(topic);
	}
	// 通过tid删除主题
	public int deleteTopic(Topic topic) throws SQLException {
		// TODO Auto-generated method stub
		return topicsDao.deleteTopic(topic);
	}

	@Override
	public List<Topic> findAlltopicId(int tid) throws SQLException {
		// TODO Auto-generated method stub
		return topicsDao.findAlltopicId(tid);
	}
	
	

}
