package cn.mybatis.jdbc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.mybatis.mapper.OrdersMapperCustom;
import cn.mybatis.po.Orders;
import cn.mybatis.po.OrdersCustom;
import cn.mybatis.po.User;
import cn.mybatis.po.UtilSessions;

public class OrdersMapperTest {
	SqlSession session = UtilSessions.getUtils().getSession("config/SqlMapConfig.xml");
	OrdersMapperCustom mapperCustom = session.getMapper(OrdersMapperCustom.class);

	public void findOrdersUser() throws Exception {
		List<OrdersCustom> ordersCustoms = mapperCustom.findOrdersUser();
		for (OrdersCustom ordersCustom : ordersCustoms) {
			System.out.println("<-- findOrdersUser() " + ordersCustom + " " + ordersCustom.getCreatetime()+ordersCustom.getNumber());
		}
	}

	public void findOrdersUserResultMap() throws Exception {
		List<Orders> orders = mapperCustom.findOrdersUserResultMap();
		for (Orders order : orders) {
			System.out.println("--> findOrdersUserResultMap()" + order + " " + order.getUser());
		}
	}
	
	public void findOrdersAndOrderDetailResultMap()throws Exception{
		List<Orders> orders = mapperCustom.findOrdersAndOrderDetailResultMap();
		for (Orders order : orders) {
			System.out.println("findOrdersAndOrderDetailResultMap()"+order.getOrderdetails()+" "+order.getUser()+" "+order.getNumber());
		}
	}
	public void findUserAndItemsResultMap()throws Exception{
		List<User> users = mapperCustom.findUserAndItemsResultMap();
		System.out.println("--");
		for (User user : users) {
			System.out.println("<-- findUserAndItemsResultMap() "+user);
		}
	}
	public void findOrdersUserLazyLoading()throws Exception{
		List<Orders> orders = mapperCustom.findOrdersUserLazyLoading();
		for (Orders order : orders) {
			System.out.println("-->findOrdersUserLazyLoading()"+ order.getUser());
		}
	}

	public static void main(String[] args) throws Exception {
		OrdersMapperTest omTest = new OrdersMapperTest();
//		omTest.findOrdersUser();
//		omTest.findOrdersUserResultMap();
//		omTest.findOrdersAndOrderDetailResultMap();
//		omTest.findOrdersUserResultMap();
		omTest.findOrdersUserLazyLoading();

		omTest.session.close();
	}
}
