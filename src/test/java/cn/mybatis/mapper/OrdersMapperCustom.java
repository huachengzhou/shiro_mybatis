package cn.mybatis.mapper;
/**
 *订单 Mapper
 */

import java.util.List;

import cn.mybatis.po.Orders;
import cn.mybatis.po.OrdersCustom;
import cn.mybatis.po.User;

public interface OrdersMapperCustom {
	/**
	 * @see 查询订单关联查询用户信息
	 * @return
	 * @throws Exception
	 */
    public List<OrdersCustom> findOrdersUser()throws Exception;
    /**
     * 查询订单关联查询用户使用resultMap
     * @return
     * @throws Exception
     */
    public List<Orders> findOrdersUserResultMap()throws Exception;
    /**
     * @see 查询订单(关联用户)及订单明细
     * @return
     * @throws Exception
     */
    public List<Orders> findOrdersAndOrderDetailResultMap()throws Exception;
    /**
     * @see 查询用户购买的商品
     * @return
     * @throws Exception
     */
    public List<User> findUserAndItemsResultMap()throws Exception;
    /**
     * @see 查询订单的用户信息 延迟加载
     * @return
     * @throws Exception
     */
    public List<Orders> findOrdersUserLazyLoading()throws Exception;
    
}
