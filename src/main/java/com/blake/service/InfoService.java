package com.blake.service;

import java.util.List;

import com.blake.base.BaseService;
import com.blake.entiyi.Info;
import com.blake.entiyi.page.PageResult_Info;
import com.blake.entiyi.vo.InfoVo;

public interface InfoService extends BaseService<Info>{
	public void add(Integer uid,Info info);
	
	/**��װ��,��װ��User���ֶ�*/
	public InfoVo getInfoVo(Integer info_id);
	
	/**����id��ȡInfo����*/
	public List<Info> findNumbersInfos(List<Integer> ids);
	
	/**��ҳ*/
	public PageResult_Info getPage(Integer pageNumber);
}
