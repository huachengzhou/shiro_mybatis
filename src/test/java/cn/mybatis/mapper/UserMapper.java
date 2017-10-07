package cn.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import cn.mybatis.po.User;
import cn.mybatis.po.UserCustom;
import cn.mybatis.po.UserQueryVo;

public interface UserMapper {
		
		//����id��ѯ�û���Ϣ
		public User findUserById(int id) throws Exception;
		
		//�����û����в�ѯ�û��б�select * from user where username like('%С%')
		public List<User> findUserByName(String name)throws Exception;
		
		//�����û�
		public void insertUser(User user)throws Exception;
		
		//ɾ���û�
		public void deleteUser(int id)throws Exception;
		
		//�޸��û�
		public void updateUser(User user)throws Exception;
		
		//��ѯ������ select count(id) from user;
		public int countUser()throws Exception;
		
		/**
		 * @see �ۺϲ�ѯ �����С��дsql
		 * @return
		 * @throws Exception
		 */
		public List<UserCustom> findUserList(UserQueryVo userQueryVo)throws Exception;
		//�ۺϲ�ѯ ��ѯ�ܵ�����
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
