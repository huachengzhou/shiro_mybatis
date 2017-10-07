package com.blake.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class PageResult<T> implements Serializable {
	// select count(*) from sys_role;
	private static final long serialVersionUID = 4444630162261607175L;
	/**每页数量*/
	private Integer pageSize = 5;
	/**数据库查询所用*/
	private Long num;
	
	/** 当前页号 */
	private Long pageNumber;
	
	/** 总记录数 */
	private Long totalCount;
	
	/**总页数 */
	private Long totalPage;

	private List<T> items = new ArrayList<T>();

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/** 获取当前页号 */
	public Long getPageNumber() {
		return pageNumber;
	}

	/** 设置当前页号 */
	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}

	/** 获取总记录数 */
	public Long getTotalCount() {
		return totalCount;
	}

	/** 设置总记录数 */
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	/** 获取总页数 */
	public Long getTotalPage() {
		if (totalCount == 0) {
			return (long) 0;
		}
		return totalCount / pageSize;
	}
	/**获取集合列表*/
	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
	
	/**数据库查询所用*/
	public Long getNum() {
		Long num = 0l;
		if (pageNumber == 0) {
			num = 0l;
		} else {
			num = (pageNumber - 1) * pageSize;
		}
		return num;
	}
	/*...................*/

	public void setNum(Long num) {
		this.num = num;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	

}
