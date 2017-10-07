package com.blake.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	/**
	 * 新增
	 * 
	 * @param entity
	 */
	public void add(T entity);

	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 根据id删除
	 * 
	 * @param entityClass
	 * @param id
	 */
	public void remove(Serializable id);

	/**
	 * 根据id查找
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public T findObjectById(Serializable id);

	/**
	 * 查找列表
	 */
	public List<T> findObjects();

	/** 批量删除 */
	public void removes(Serializable[] ids);
}
