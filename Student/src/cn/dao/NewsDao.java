package cn.dao;

import java.sql.SQLException;
import java.util.List;



import cn.entity.News;
import cn.entity.Page;



public interface NewsDao {
	// 获取所有新闻
	public List<News> getAllnews() throws SQLException;

	// 获取某主题下的所有新闻（根据主题id）
	public List<News> getAllnewsByTID(int tid) throws SQLException;

	// 获取某主题下的所有新闻（根据主题名称）
	public List<News> getAllnewsByTname(String tname) throws SQLException;

	// 获取某主题下的新闻数量
	public int getNewsCountByTID(int Tid) throws SQLException;

	// 获取某主题下的最新新闻
	public List<News> getLatestNewsByTID(int tid, int limit)
			throws SQLException;

	// 获取某条新闻
	public News getNewsByNID(int nid) throws SQLException;

	// 添加新闻信息
	public int Savae(News news);

	// 添加新闻加文件
	public int addNews(News news);

	// 删除新闻
	public int del(News news);

	// 修改新闻
	public int update(News news);

	// 获得新闻总数
	public int getTotalCount() throws SQLException;

	// 分页获得新闻
	public List<News> getPageNewsList(int pageNo, int pageSize)
			throws SQLException;

	// 侧边栏新闻
	public List<News> getAllnewsByNTID(String ntid) throws SQLException;

	// 主页根据主题显示新闻信息
	public List<News> getAllnewsByNtid(String ntid) throws SQLException;
	
	public Page pageQuery(Page page) throws SQLException;

}