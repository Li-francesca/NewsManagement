package cn.service;

import java.sql.SQLException;
import java.util.List;

import cn.entity.Topic;



public interface TopicsService {
	// 获取所有主题
	public List<Topic> findAllTopics() throws SQLException;

	// 根据ID查找主题名称
	public List<Topic> findAlltopicId(int tid) throws SQLException;

	// 更新所有主题
	public int updateTopic(Topic topic) throws SQLException;

	// 根据名字查找主题
	public boolean findTopicByName(String name) throws SQLException;

	// 添加主题
	public int addTopic(Topic topic) throws SQLException;

	// 通过tid删除主题
	public int deleteTopic(Topic topic) throws SQLException;

}
