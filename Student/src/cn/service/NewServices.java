package cn.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import cn.entity.News;
import cn.entity.Page;



public interface NewServices {
	
	// 获取所有新闻
	public List<News> findAllNews() throws SQLException;

	// 获取某主题下的所有新闻（根据主题id）
	public List<News> findAllNewsByTid(int tid) throws SQLException;

	// 获取某主题下的所有新闻（根据主题名称）
	public List<News> findAllNewsByTname(String tname) throws SQLException;

	// 获取某主题下的最新新闻
	public List<News> findLatestNewsByTid(int tid, int limit)
			throws SQLException;

	// 初始化一组主题下的最新新闻
	public List<List<News>> findLatestNewsByTid(Map<Integer, Integer> topicsMap)
			throws SQLException;

	// 获取某条新闻
	public News findNewsByNid(int nid) throws SQLException;

	// 添加新闻
	public int Savae(News news);

	// 添加新闻加文件
	public int addNews(News news);

	// 删除新闻
	public int del(News news);

	//
	public int upadte(News news);

	// 获得新闻总数
	public int getTotalCount() throws SQLException;

	// 分页获得新闻
	public List<News> getPageNewsList(int pageNo, int pageSize)
			throws SQLException;

	// 侧边栏新闻
	public List<News> getAllnewsByNTID(String ntid) throws SQLException;
	/**
	 * 新闻的 分页查询
	 * @param page
	 * @return
	 */
    public Page pageQuery(Page page) throws SQLException;
      
}
