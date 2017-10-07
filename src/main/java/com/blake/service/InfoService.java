package com.blake.service;

import java.util.List;

import com.blake.base.BaseService;
import com.blake.entiyi.Info;
import com.blake.entiyi.page.PageResult_Info;
import com.blake.entiyi.vo.InfoVo;

public interface InfoService extends BaseService<Info>{
	public void add(Integer uid,Info info);
	
	/**包装类,包装了User的字段*/
	public InfoVo getInfoVo(Integer info_id);
	
	/**根据id获取Info集合*/
	public List<Info> findNumbersInfos(List<Integer> ids);
	
	/**分页*/
	public PageResult_Info getPage(Integer pageNumber);
}
