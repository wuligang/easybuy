package cn.easybuy.service.user;

import cn.easybuy.dao.order.UserAddressDao;
import cn.easybuy.dao.order.UserAddressDaoImpl;
import cn.easybuy.entity.UserAddress;
import cn.easybuy.param.UserAddressParam;
import cn.easybuy.utils.JDBCUtil;

import java.sql.Connection;
import java.util.List;

/**
 * Created by wlg on 2018/5/8.
 */
public class UserAddressServiceImpl implements UserAddressService {
    /**
     * 查询用户地址列表
     *
     * @param id
     * @return
     * @throws Exception
     */
    public List<UserAddress> queryUserAdressList(Integer id){
        Connection connection = null;
        List<UserAddress> userAddressList = null;
        try {
            connection = JDBCUtil.openConnection();
            UserAddressDao userAddressDao = new UserAddressDaoImpl(connection);
            UserAddressParam params = new UserAddressParam();
            params.setUserId(id);
            userAddressList = userAddressDao.queryUserAddressList(params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	JDBCUtil.closeConnection(connection);
        }
        return userAddressList;
    }
    /**
     * 添加用户地址
     *
     * @param id
     * @param address
     * @return
     */
    @Override
    public Integer addUserAddress(Integer id, String address,String remark) {
        Connection connection = null;
        Integer userAddressId = null;
        try {
            connection = JDBCUtil.openConnection();
            UserAddressDao userAddressDao = new UserAddressDaoImpl(connection);
            UserAddress userAddress=new UserAddress();
            userAddress.setUserId(id);
            userAddress.setAddress(address);
            userAddress.setRemark(remark);
            userAddressId = userAddressDao.add(userAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	JDBCUtil.closeConnection(connection);
        }
        return userAddressId;
    }

    @Override
    public UserAddress getUserAddressById(Integer id) {
        Connection connection = null;
        UserAddress userAddress= null;
        try {
            connection = JDBCUtil.openConnection();
            UserAddressDao userAddressDao = new UserAddressDaoImpl(connection);
            userAddress = (UserAddress) userAddressDao.getUserAddressById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
            return  userAddress;
        }
    }
}
