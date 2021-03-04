package cn.easybuy.service.news;

import cn.easybuy.dao.news.NewsDao;
import cn.easybuy.dao.news.NewsDaoImpl;
import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;
import cn.easybuy.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class NewsServiceImpl implements NewsService {

	public void deleteNews(String id) {// 删除新闻
		Connection connection=null;
		try {
			connection= JDBCUtil.openConnection();
			NewsDao newsDao = new NewsDaoImpl(connection);
			newsDao.deleteById(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConnection(connection);
		}
	}

	public News findNewsById(String id) {// 根据ID获取新闻
		News news = null;
		Connection connection=null;
		try {
			connection= JDBCUtil.openConnection();
			NewsDao newsDao = new NewsDaoImpl(connection);
			news = newsDao.getNewsById(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(connection);
		}
		return news;
	}

	public void addNews(News news) {// 保存新闻
		Connection connection = null;
		try {
			connection = JDBCUtil.openConnection();
			NewsDao newsDao = new NewsDaoImpl(connection);
			newsDao.add(news);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(connection);
		}
	}

	public void updateNews(News news) {// 更新留言
		Connection connection = null;
		try {
			connection = JDBCUtil.openConnection();
			NewsDao newsDao = new NewsDaoImpl(connection);
			newsDao.update(news);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(connection);
		}
	}

	
	public List<News> queryNewsPageList(NewsParams param) throws SQLException {
		List<News> newsList=new ArrayList<News>();
		Connection connection = null;
		NewsDao newsDao =null;
		try {
			connection = JDBCUtil.openConnection();
			newsDao= new NewsDaoImpl(connection);
			newsList=newsDao.queryNewsList(param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(connection.isClosed());
			JDBCUtil.closeConnection(connection);
		}
		return newsList;
	}
	
	@Override
	public List<News> queryNewsList(NewsParams param) {
		List<News> newsList=new ArrayList<>();
		Connection connection = null;
		try {
			connection = JDBCUtil.openConnection();
			NewsDao newsDao = new NewsDaoImpl(connection);
			newsList=newsDao.queryNewsList(param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(connection);
		}
		return newsList;
	}

	@Override
	public Integer queryNewsCount(NewsParams param) {
		Connection connection = null;
		Integer count=0;
		try {
			connection = JDBCUtil.openConnection();
			NewsDao newsDao = new NewsDaoImpl(connection);
			count=newsDao.queryNewsCount(param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(connection);
			return count;
		}
	}

}
