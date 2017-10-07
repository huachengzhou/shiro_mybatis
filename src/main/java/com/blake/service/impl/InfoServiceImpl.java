package com.blake.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blake.dao.InfoDao;
import com.blake.dao.UserDao;
import com.blake.entiyi.Info;
import com.blake.entiyi.User;
import com.blake.entiyi.page.PageResult_Info;
import com.blake.entiyi.vo.InfoVo;
import com.blake.service.InfoService;

@Service("infoService")
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoDao infoDao;

	@Autowired
	private UserDao userDao;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void add(Info entity) {
		infoDao.addInfo(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void add(Integer uid, Info info) {
		User user = userDao.getUser(uid);
		info.setUser(user);
		infoDao.addInfo(info);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void update(Info entity) {
		infoDao.updateInfo(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void remove(Serializable id) {
		infoDao.deleteInfo((Integer) id);
	}

	public Info findObjectById(Serializable id) {
		return infoDao.getInfo((Integer) id);
	}

	public List<Info> findObjects() {
		return infoDao.findInfos();
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void removes(Serializable[] ids) {
		List<Integer> integers = new ArrayList<Integer>();
		for (Serializable integer : ids) {
			integers.add((Integer) integer);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", integers);
		infoDao.removeNumbers(map);
	}

	public InfoVo getInfoVo(Integer info_id) {
		return infoDao.getInfoVo(info_id);
	}

	public List<Info> findNumbersInfos(List<Integer> ids) {
		InfoVo infoVo = new InfoVo();
		infoVo.setIds(ids);
		return infoDao.findNumbersInfos(infoVo);
	}

	public PageResult_Info getPage(Integer pageNumber) {
		Long totalCount = infoDao.getLongNumber();
		PageResult_Info page = new PageResult_Info();
		page.setTotalCount(totalCount);
		page.setPageNumber(Long.valueOf(pageNumber));
		
		List<Info> infos = infoDao.getPages(page);
		page.setItems(infos);
		page.setTotalCount(totalCount);
		return page;
	}

}
