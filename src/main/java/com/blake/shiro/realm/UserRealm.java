package com.blake.shiro.realm;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.blake.common.Base64Util;
import com.blake.entiyi.User;
import com.blake.service.UserService;


public class UserRealm extends AuthorizingRealm{
	
	@Resource
	private UserService userService;
	
	/**��ȡ�����֤�����Ϣ*/
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		System.out.println("doGetAuthorizationInfo:"+username);
		Set<String> rSet = userService.findRoles(username);
		Set<String> stringPermissions = userService.findPermissions(username);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(rSet);//��ӽ�ɫ��Ϣ
		authorizationInfo.setStringPermissions(stringPermissions);//���Ȩ����Ϣ
		return authorizationInfo;
	}

	/**��ȡ��Ȩ��Ϣ*/
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();
		User user = userService.loginUser(username);
		System.out.println("username:"+username+"<------");
		System.out.println("user:"+user+"----->");
		if(user == null) {
            throw new UnknownAccountException();//û�ҵ��ʺ�
        }
		String pass = Base64Util.getString(user.getPassword());
		pass = pass.substring(0,pass.lastIndexOf(user.getSalt()));
		//����AuthenticatingRealmʹ��CredentialsMatcher��������ƥ��
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //�û���
                pass, //����-->����֮���ٱȽ�
                ByteSource.Util.bytes(user.getSalt()),//salt=username+salt
                getName()  //realm name
        );
		return authenticationInfo;
	}

	/**------------------------ok-----------------------------**/
	protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	protected void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}
	/**------------------------ok-----------------------------**/
	public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
