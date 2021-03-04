package cn.easybuy.service.user;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.easybuy.dao.user.UserDao;
import cn.easybuy.dao.user.UserDaoImpl;
import cn.easybuy.utils.JDBCUtil;
import org.apache.log4j.Logger;
import cn.easybuy.entity.User;

public class UserServiceImpl implements UserService {
	
	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public boolean add(User user){
		Connection connection = null;
		Integer count=0;
		try {
			connection = JDBCUtil.openConnection();
			UserDao userDao = new UserDaoImpl(connection);
			count=userDao.add(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection(connection);
			return  count>0;
		}
	}

	@Override
	public boolean update(User user) {
		Connection connection = null;
		Integer count=0;
		try {
			connection = JDBCUtil.openConnection();
			UserDao userDao = new UserDaoImpl(connection);
			count=userDao.update(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection(connection);
			return  count>0;
		}
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		Connection connection = null;
		Integer count=0;
		try {
			connection = JDBCUtil.openConnection();
			UserDao userDao = new UserDaoImpl(connection);
			count=userDao.deleteUserById(userId+"");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection(connection);
			return  count>0;
		}
	}

	@Override
	public User getUser(Integer userId, String loginName) {
		Connection connection = null;
		User user=null;
		try {
			connection = JDBCUtil.openConnection();
			UserDao userDao = new UserDaoImpl(connection);
			user=userDao.getUser(userId,loginName);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection(connection);
			return user;
		}
	}

	@Override
	public List<User> getUserList(Integer currentPageNo, Integer pageSize) {
		Connection connection = null;
		List<User> userList=null;
		try {
			connection = JDBCUtil.openConnection();
			UserDao userDao = new UserDaoImpl(connection);
			userList=userDao.getUserList(currentPageNo,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection(connection);
			return userList;
		}
	}

	@Override
	public int count() {
		Connection connection = null;
		Integer count=null;
		try {
			connection = JDBCUtil.openConnection();
			UserDao userDao = new UserDaoImpl(connection);
			count=userDao.count();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection(connection);
			return count;
		}
	}
}
