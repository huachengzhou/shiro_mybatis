package cn.mybatis.po;
import java.io.IOException;
import java.io.InputStream;
/**
 *单例模式  return Session
 */
public class UtilSessions {
    private static UtilSessions utilSessions;
    /**
     * @see 单例模式
     * @return UtilSessions
     */
    public static UtilSessions getUtils(){
    	if(utilSessions==null){
    		utilSessions = new UtilSessions();
    	}
    	return utilSessions;
    }
    /**
     * @param path
     * @return Session
     */
    public org.apache.ibatis.session.SqlSession getSession(String path){
    	InputStream in = null;
		try {
			in = org.apache.ibatis.io.Resources.getResourceAsStream(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		org.apache.ibatis.session.SqlSessionFactory sessionFactory = new org.apache.ibatis.session.SqlSessionFactoryBuilder().build(in);
		return sessionFactory.openSession();
    }
    private UtilSessions(){
    }
}
