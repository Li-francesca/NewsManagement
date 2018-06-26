package cn.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import cn.dao.BaseDao;
import cn.dao.NewsDao;
import cn.dao.impl.NewsDaoImpl;
import cn.entity.News;
import cn.entity.Page;
import cn.service.NewServices;


public class NewsServiceImol implements NewServices {
	NewsDao newsDao = new NewsDaoImpl();

	public List<News> findAllNews() throws SQLException {
		// TODO Auto-generated method stub
		return newsDao.getAllnews();
	}

	public List<News> findAllNewsByTid(int tid) throws SQLException {
		// TODO Auto-generated method stub
		return newsDao.getAllnewsByTID(tid);
	}

	public List<News> findAllNewsByTname(String tname) throws SQLException {
		// TODO Auto-generated method stub
		return newsDao.getAllnewsByTname(tname);
	}

	public List<News> findLatestNewsByTid(int tid, int limit)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<List<News>> findLatestNewsByTid(Map<Integer, Integer> topicsMap)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public News findNewsByNid(int nid) throws SQLException {
		// TODO Auto-generated method stub
		return newsDao.getNewsByNID(nid);
	}

	public int Savae(News news) {
		// TODO Auto-generated method stub
		return newsDao.Savae(news);
	}

	public int del(News news) {
		// TODO Auto-generated method stub
		return newsDao.del(news);
	}

	public int upadte(News news) {
		// TODO Auto-generated method stub
		return newsDao.update(news);
	}

	@Override
	public int getTotalCount() throws SQLException {
		// TODO Auto-generated method stub
		return newsDao.getTotalCount();
	}

	@Override
	public List<News> getPageNewsList(int pageNo, int pageSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return newsDao.getPageNewsList(pageNo, pageSize);
	}

	@Override
	public int addNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.addNews(news);
	}

	@Override
	public List<News> getAllnewsByNTID(String ntid) throws SQLException {
		// TODO Auto-generated method stub
		return newsDao.getAllnewsByNTID(ntid);
	}
	
	/**
	 * 新闻的 分页查询
	 * @param page
	 * @return
	 */
	public Page pageQuery(Page page) throws SQLException {
		return newsDao.pageQuery(page);
	}
	
	/*
    public Page pageQuery(Page page) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        BaseDao baseDao = new BaseDao();
        try{
        	
        	//  select * from cms_article limit (page.getPageNo())*page.getPageSize(),page.getPageSize()
           // conn = baseDao.getConnection();
            String sql = "SELECT `nid`, `ntid`, `ntitle`, `nauthor`,"
    				+ " `ncreateDate`, `nsummary`, `tname` FROM `NEWS`, `TOPIC`"
    				+ " WHERE `NEWS`.`ntid` = `TOPIC`.`tid`"
    				+ " ORDER BY `ncreateDate` DESC LIMIT ?, ?";
           // st = conn.prepareStatement(sql);
            st.setInt(1, (page.getPageNo()-1)*page.getPageSize());
            st.setInt(2, page.getPageSize());
            //rs = st.executeQuery();
            rs = this.exxcuteQuery(sql, (page.getPageNo()-1) * page.getPageSize(), page.getPageSize());
            //rs = this.exxcuteQuery(sql, (pageNo - 1) * pageSize, pageSize);
            //rs = baseDao.exxcuteQuery(sql);
            List contentList = new ArrayList();
            News news = null;
            while(rs.next()) {
            	news = new News();
				news.setNid(rs.getString("nid"));
				news.setNtid(rs.getString("ntid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreatedate(rs.getString("ncreateDate"));
				news.setNsummary(rs.getString("nsummary"));
				news.setNtname(rs.getString("tname"));
				//list.add(news);
                contentList.add(news);
            }
            page.setList(contentList);
            //获取了页面数据后还没结束，还得获取总记录数
            sql = "select count(*) from cms_article";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                int totalRecords = rs.getInt(1);  //rs.getInt("count(*)")也是可以的
                page.setCount(totalRecords);
            }
            return page;    
        }catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

	private ResultSet exxcuteQuery(String sql, int i, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
