package com.blake.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class PageResult<T> implements Serializable {
	// select count(*) from sys_role;
	private static final long serialVersionUID = 4444630162261607175L;
	/**ÿҳ����*/
	private Integer pageSize = 5;
	/**���ݿ��ѯ����*/
	private Long num;
	
	/** ��ǰҳ�� */
	private Long pageNumber;
	
	/** �ܼ�¼�� */
	private Long totalCount;
	
	/**��ҳ�� */
	private Long totalPage;

	private List<T> items = new ArrayList<T>();

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/** ��ȡ��ǰҳ�� */
	public Long getPageNumber() {
		return pageNumber;
	}

	/** ���õ�ǰҳ�� */
	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}

	/** ��ȡ�ܼ�¼�� */
	public Long getTotalCount() {
		return totalCount;
	}

	/** �����ܼ�¼�� */
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	/** ��ȡ��ҳ�� */
	public Long getTotalPage() {
		if (totalCount == 0) {
			return (long) 0;
		}
		return totalCount / pageSize;
	}
	/**��ȡ�����б�*/
	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
	
	/**���ݿ��ѯ����*/
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
