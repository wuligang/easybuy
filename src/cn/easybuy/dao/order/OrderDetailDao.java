package cn.easybuy.dao.order;
import cn.easybuy.entity.OrderDetail;
import cn.easybuy.param.OrderDetailParam;

import java.util.List;

/**
 * 订单详细
 * Created by wlg on 2018/4/27.
 */
public interface OrderDetailDao {

    public void add(OrderDetail detail) throws Exception;

	public void deleteById(OrderDetail detail) throws Exception;
	
	public OrderDetail getOrderDetailById(Integer id)throws Exception; 
	
	public List<OrderDetail> getOrderDetailList(Integer orderId)throws Exception;
	
	public Integer queryOrderDetailCount(OrderDetailParam params)throws Exception; 
}
