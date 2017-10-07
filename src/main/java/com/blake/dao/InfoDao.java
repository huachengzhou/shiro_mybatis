package com.blake.dao;

import java.util.List;
import java.util.Map;

import com.blake.entiyi.Info;
import com.blake.entiyi.page.PageResult_Info;
import com.blake.entiyi.vo.InfoVo;

public interface InfoDao {

	/** 增加信息 */
	public void addInfo(Info info);

	public Info getInfo(Integer info_id);

	public List<Info> findInfos();

	public void deleteInfo(Integer info_id);

	public void updateInfo(Info info);

	/** 包装类,包装了User的字段 */
	public InfoVo getInfoVo(Integer info_id);
	
	public List<Info> findNumbersInfos(InfoVo fInfoVo);
	
	public void removeNumbers(Map<String,Object> map);
	
	public List<Info> getPages(PageResult_Info page);
	
	public Long getLongNumber();
}
