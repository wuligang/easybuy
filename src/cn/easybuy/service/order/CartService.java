package cn.easybuy.service.order;

import cn.easybuy.utils.ShoppingCart;

/**
 * Created by wlg on 2018/5/8.
 */
public interface CartService {

    public ShoppingCart modifyShoppingCart(String productId, String quantityStr, ShoppingCart cart) throws Exception;

    public ShoppingCart calculate(ShoppingCart cart)throws Exception;
}
