package cn.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.mysql.jdbc.StringUtils;


public class Page<T> {

	private int pageNo = 1; // 当前页码
	private int pageSize = 20; // 页面大小，设置为“-1”表示不进行分页（分页无效）

	private long count;// 总记录数，设置为“-1”表示不查询总数


	private List<T> list = new ArrayList<T>();


	public Page() {
		this.pageSize = -1;
	}

	/**
	 * 构造方法
	 *
	 * @param request
	 *            传递 repage 参数，来记住页码
	 * @param response
	 *            用于设置 Cookie，记住页码
	 */
	public Page(HttpServletRequest request, HttpServletResponse response) {
		this(request, response, -2);
	}

	/**
	 * 构造方法
	 *
	 * @param request
	 *            传递 repage 参数，来记住页码
	 * @param response
	 *            用于设置 Cookie，记住页码
	 * @param defaultPageSize
	 *            默认分页大小，如果传递 -1 则为不分页，返回所有数据
	 */
	public Page(HttpServletRequest request, HttpServletResponse response, int defaultPageSize) {
		// 设置页码参数（传递repage参数，来记住页码）
		String no = request.getParameter("pageNo");
		
		
		
		//张   三
		if(StringUtils.isNullOrEmpty(no)){
			no="1";
		}
		this.setPageNo(Integer.parseInt(no));
		
		// 设置页面大小参数（传递repage参数，来记住页码大小）
		String size = request.getParameter("pageSize");
		
		if(null==size){
			size="20";
		}
		
		this.setPageSize(Integer.parseInt(size));
		
	}

	/**
	 * 构造方法
	 *
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            分页大小
	 */
	public Page(int pageNo, int pageSize) {
		this(pageNo, pageSize, 0);
	}

	/**
	 * 构造方法
	 *
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            分页大小
	 * @param count
	 *            数据条数
	 */
	public Page(int pageNo, int pageSize, long count) {
		this(pageNo, pageSize, count, new ArrayList<T>());
	}

	/**
	 * 构造方法
	 *
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            分页大小
	 * @param count
	 *            数据条数
	 * @param list
	 *            本页数据对象列表
	 */
	public Page(int pageNo, int pageSize, long count, List<T> list) {
		this.setCount(count);
		this.setPageNo(pageNo);
		this.pageSize = pageSize;
		this.list = list;
	}



	/**
	 * 获取分页HTML代码
	 *
	 * @return
	 */
	public String getHtml() {
		return toString();
	}

	public static void main(String[] args) {
		Page<String> p = new Page<String>(3, 3);
		System.out.println(p);
	}

	/**
	 * 获取设置总数
	 *
	 * @return
	 */
	public long getCount() {
		return count;
	}

	/**
	 * 设置数据总数
	 *
	 * @param count
	 */
	public void setCount(long count) {
		this.count = count;
		if (pageSize >= count) {
			pageNo = 1;
		}
	}

	/**
	 * 获取当前页码
	 *
	 * @return
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * 设置当前页码
	 *
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * 获取页面大小
	 *
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置页面大小（最大500）
	 *
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize > 500 ? 500 : pageSize;
	}





	/**
	 * 获取本页数据对象列表
	 *
	 * @return List<T>
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 设置本页数据对象列表
	 *
	 * @param list
	 */
	public Page<T> setList(List<T> list) {
		this.list = list;
//		initialize();
		return this;
	}



	/**
	 * 分页是否有效
	 *
	 * @return this.pageSize==-1
	 */
	public boolean isDisabled() {
		return this.pageSize == -1;
	}

	/**
	 * 是否进行总数统计
	 *
	 * @return this.count==-1
	 */
	public boolean isNotCount() {
		return this.count == -1;
	}

	/**
	 * 获取 Hibernate FirstResult
	 */
	public int getFirstResult() {
		int firstResult = (getPageNo() - 1) * getPageSize();
		if (firstResult >= getCount()) {
			firstResult = 0;
		}
		return firstResult;
	}

	/**
	 * 获取 Hibernate MaxResults
	 */
	public int getMaxResults() {
		return getPageSize();
	}


}
