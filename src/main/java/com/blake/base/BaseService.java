package com.blake.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	/**
	 * ����
	 * 
	 * @param entity
	 */
	public void add(T entity);

	/**
	 * ����
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * ����idɾ��
	 * 
	 * @param entityClass
	 * @param id
	 */
	public void remove(Serializable id);

	/**
	 * ����id����
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public T findObjectById(Serializable id);

	/**
	 * �����б�
	 */
	public List<T> findObjects();

	/** ����ɾ�� */
	public void removes(Serializable[] ids);
}
