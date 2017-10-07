package cn.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import cn.mybatis.po.User;
import cn.mybatis.po.UserCustom;
import cn.mybatis.po.UserQueryVo;

public interface UserMapper {
		
		//根据id查询用户信息
		public User findUserById(int id) throws Exception;
		
		//根据用户名列查询用户列表select * from user where username like('%小%')
		public List<User> findUserByName(String name)throws Exception;
		
		//插入用户
		public void insertUser(User user)throws Exception;
		
		//删除用户
		public void deleteUser(int id)throws Exception;
		
		//修改用户
		public void updateUser(User user)throws Exception;
		
		//查询总数量 select count(id) from user;
		public int countUser()throws Exception;
		
		/**
		 * @see 综合查询 必须得小心写sql
		 * @return
		 * @throws Exception
		 */
		public List<UserCustom> findUserList(UserQueryVo userQueryVo)throws Exception;
		//综合查询 查询总的数量
		public int findUserCount(UserQueryVo userQueryVo)throws Exception;
		/**
		 * @see key 
		 * @param hashMap
		 * @return
		 * @throws Exception
		 */
		
		public User findUserByIdResultMap(int id)throws Exception;
		
		public HashMap<String,Object> findUserByHashMap(User user)throws Exception;
}
