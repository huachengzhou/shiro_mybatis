package cn.mybatis.jdbc;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.mybatis.mapper.UserMapper;
import cn.mybatis.po.User;
import cn.mybatis.po.UserCustom;
import cn.mybatis.po.UserQueryVo;
import cn.mybatis.po.UtilSessions;

public class UserMapperTest {

	SqlSession session = UtilSessions.getUtils().getSession("config/SqlMapConfig.xml");
	UserMapper userMapper = session.getMapper(UserMapper.class);

	@Test
	public void isit(){
		System.out.println(session);
	}
	public void selectFind() throws Exception {
		User user = userMapper.findUserById(2);
		System.out.println(user);
		session.commit();
	}

	public void insertUser() throws Exception {
		User user = new User("Alice", "fmale", new java.sql.Timestamp(System.currentTimeMillis()), "中国");
		userMapper.insertUser(user);
		System.out.println(user.getId());
		session.commit();
	}

	public void updateUser() throws Exception {
		User user = new User("Blake", "fmale", new Date(), "中国");
		user.setId(8);
		userMapper.updateUser(user);
		session.commit();
	}

	public void deleteUser() throws Exception {
		userMapper.deleteUser(16);
		session.commit();
	}

	public void countUser() throws Exception {
		int num = userMapper.countUser();
		System.out.println(num);
	}

	@Test
	public void findUserList() throws Exception {
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setId(3);
		userCustom.setUsername("小");
		userQueryVo.setUserCustom(userCustom);
		userQueryVo.getIds().add(4);
		userQueryVo.getIds().add(5);
		userQueryVo.getIds().add(6);
		List<UserCustom> userCustoms = userMapper.findUserList(userQueryVo);
		List<UserCustom> userCustoms2 = userMapper.findUserList(userQueryVo);
		for (UserCustom userCustom2 : userCustoms) {
			System.out.println("--> findUserList() " + userCustom2);
		}
		System.out.println(userCustoms2);
	}

	public void findUserCount() throws Exception {
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setId(3);
		userCustom.setUsername("小"); // 已经使用动态SQL,不添加username条件那么查询的结果集数量一定是大于或者等于添加了username判断的结果集数量
		userQueryVo.setUserCustom(userCustom);// 已经使用动态SQL
		int num = userMapper.findUserCount(userQueryVo);
		System.out.println("findUserCount() " + num);
	}

	public void findUserByName() throws Exception {
		List<User> users = userMapper.findUserByName("小");
		session.commit();
		for (User user : users) {
			System.out.println(user);
		}
	}

	public void findUserByIdResultMap() throws Exception {
		User user = userMapper.findUserByIdResultMap(4);
		System.out.println("<-- findUserByIdResultMap() " + user);
	}

	@Test
	public void findUserByHashMap() throws Exception {
		User user = new User();
		user.setId(3);
		user.setUsername("小");
		HashMap<String, Object> hashMap = userMapper.findUserByHashMap(user);
		session.commit();
		System.out.println("findUserByHashMap() " + " key:" + hashMap.keySet() + hashMap);
		Set<Entry<String, Object>> set = hashMap.entrySet();
		for (Entry<String, Object> entry : set) {
			System.out.println("key:" + entry.getKey() + ";value:" + entry.getValue());
		}

	}

}
