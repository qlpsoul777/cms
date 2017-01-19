package com.qlp.cms.service.permission;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlp.cms.entity.permission.User;
import com.qlp.core.enums.UserStatusEnum;

public class DataBaseRelam extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String identifying = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.setRoles(userService.findRolesByLoginName(identifying));
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String loginName = (String) token.getPrincipal();
		User user = userService.findByLoginName(loginName);
		//TODO 判断
		if(user == null){
            throw new UnknownAccountException();
        }
        if(UserStatusEnum.LOCKED.getCode() == user.getStatus()){
            throw new LockedAccountException();
        }
		return new SimpleAuthenticationInfo(loginName,user.getPassword(),ByteSource.Util.bytes(loginName + user.getSalt()),getName());
	}

}
