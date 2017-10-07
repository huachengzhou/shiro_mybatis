package cn.mybatis.daoTest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.mybatis.dao.UserDao;
import cn.mybatis.po.Orderdetail;
import cn.mybatis.po.Orders;
import cn.mybatis.po.OrdersCustom;
import cn.mybatis.po.User;
import cn.mybatis.po.UtilSessions;

public class UserDaoTest {
	SqlSession session = UtilSessions.getUtils().getSession("config/SqlMapConfig.xml");
	UserDao userDao = session.getMapper(UserDao.class);
	
	@Test
	public void isit(){
		System.out.println(userDao.getClass().getSimpleName());
	}
	
	@Test
	public void selectOrdersCustomTest(){
		List<OrdersCustom> customs = userDao.selectOrdersCustom();
		for (OrdersCustom ordersCustom : customs) {
			System.out.println(ordersCustom);
		}
	}
	
	@Test
	public void slectOrders(){
		List<Orders> orders = userDao.slectOrders();
		for (Orders orders2 : orders) {
			System.out.println(orders2);
		}
	}
	
	@Test
	public void slectOrdersAndList(){
		List<Orders> orders = userDao.slectOrdersAndList();
		for (Orders orders2 : orders) {
			List<Orderdetail> orderdetails = orders2.getOrderdetails();
			for (Orderdetail orderdetail : orderdetails) {
				System.out.println(orderdetail);
			}
		}
	}
	
	@Test
	public void findList(){
		List<User> users = userDao.findList();
		for (User user : users) {
			System.out.println(user);
		}
	}
}
