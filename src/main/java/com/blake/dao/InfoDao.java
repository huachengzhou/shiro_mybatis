package com.blake.dao;

import java.util.List;
import java.util.Map;

import com.blake.entiyi.Info;
import com.blake.entiyi.page.PageResult_Info;
import com.blake.entiyi.vo.InfoVo;

public interface InfoDao {

	/** ������Ϣ */
	public void addInfo(Info info);

	public Info getInfo(Integer info_id);

	public List<Info> findInfos();

	public void deleteInfo(Integer info_id);

	public void updateInfo(Info info);

	/** ��װ��,��װ��User���ֶ� */
	public InfoVo getInfoVo(Integer info_id);
	
	public List<Info> findNumbersInfos(InfoVo fInfoVo);
	
	public void removeNumbers(Map<String,Object> map);
	
	public List<Info> getPages(PageResult_Info page);
	
	public Long getLongNumber();
}
