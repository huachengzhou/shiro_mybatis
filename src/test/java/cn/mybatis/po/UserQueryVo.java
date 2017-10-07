package cn.mybatis.po;

import java.util.ArrayList;
import java.util.List;

/**
 *包装类型
 */
public class UserQueryVo {
    private UserCustom userCustom;
    private List<Integer> ids = new ArrayList<Integer>();

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public UserQueryVo() {
	}

	public UserQueryVo(UserCustom userCustom,List<Integer> ids) {
		this.userCustom = userCustom;
		this.ids = ids;
	}
    
}
