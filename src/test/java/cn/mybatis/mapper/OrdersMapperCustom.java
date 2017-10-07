package cn.mybatis.mapper;
/**
 *���� Mapper
 */

import java.util.List;

import cn.mybatis.po.Orders;
import cn.mybatis.po.OrdersCustom;
import cn.mybatis.po.User;

public interface OrdersMapperCustom {
	/**
	 * @see ��ѯ����������ѯ�û���Ϣ
	 * @return
	 * @throws Exception
	 */
    public List<OrdersCustom> findOrdersUser()throws Exception;
    /**
     * ��ѯ����������ѯ�û�ʹ��resultMap
     * @return
     * @throws Exception
     */
    public List<Orders> findOrdersUserResultMap()throws Exception;
    /**
     * @see ��ѯ����(�����û�)��������ϸ
     * @return
     * @throws Exception
     */
    public List<Orders> findOrdersAndOrderDetailResultMap()throws Exception;
    /**
     * @see ��ѯ�û��������Ʒ
     * @return
     * @throws Exception
     */
    public List<User> findUserAndItemsResultMap()throws Exception;
    /**
     * @see ��ѯ�������û���Ϣ �ӳټ���
     * @return
     * @throws Exception
     */
    public List<Orders> findOrdersUserLazyLoading()throws Exception;
    
}
