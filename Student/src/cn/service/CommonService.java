package cn.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dao.NewsDao;
import cn.dao.impl.NewsDaoImpl;
import cn.entity.News;


public class CommonService {
	public News toget(int id) throws SQLException{
		News n = new News();
		NewsDao newsDao = new NewsDaoImpl();
		n = newsDao.getNewsByNID(id);
		return n;
	}
	public List<News> togets(int tid) throws SQLException{
		News n = new News();
		List<News> list = new ArrayList<News>();
		NewsDao newsDao = new NewsDaoImpl();
		list = newsDao.getAllnewsByTID(tid);
		return list;
	}
	/*public List<Type> toquery(){
		CommonDao c2Dao = new CommonDao();
		List<Type> typeresult=new ArrayList<Type>();	
		typeresult = c2Dao.query();
		return typeresult;
	}*/
}
