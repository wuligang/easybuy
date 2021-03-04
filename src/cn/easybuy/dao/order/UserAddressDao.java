package cn.easybuy.dao.order;

import cn.easybuy.entity.UserAddress;
import cn.easybuy.param.UserAddressParam;

import java.util.List;

/**
 * Created by wlg on 2018/5/8.
 * addObject(UserAddress userAddress)
 * getRowList(params)
 */
public interface UserAddressDao {
	
	public List<UserAddress> queryUserAddressList(UserAddressParam param);
	
	public Integer add(UserAddress userAddress);
	
	public UserAddress getUserAddressById(Integer addressId);

}
