package cn.mybatis.dao;

import java.util.List;

import cn.mybatis.po.Orders;
import cn.mybatis.po.OrdersCustom;
import cn.mybatis.po.User;

public interface UserDao {
	
	public List<OrdersCustom> selectOrdersCustom();
	
	public List<Orders> slectOrders();
	
	public List<Orders> slectOrdersAndList();
	
	public List<User> findList();
}
