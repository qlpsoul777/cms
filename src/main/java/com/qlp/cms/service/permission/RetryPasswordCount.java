package com.qlp.cms.service.permission;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlp.cms.entity.permission.User;
import com.qlp.core.enums.UserStatusEnum;
import com.qlp.core.util.RedisUtil;

public class RetryPasswordCount extends HashedCredentialsMatcher{
	
	private int limit = 3;  //密码重试次数限制，默认为3次，可通过配置文件修改次数限制数
	private static final String SUFFIX = "RetryPasswordCountCache:";
	
	@Autowired
	private UserService userService;
	
	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
		
		String loginName = (String) token.getPrincipal();
		String key = key(loginName);
		AtomicInteger count = (AtomicInteger) RedisUtil.get(key);
		if(count ==null){
			count = new AtomicInteger(0);
		}
		if(count.incrementAndGet() > limit){
			User user = userService.findByLoginName(loginName);
			if(user != null){
				user.setStatus(UserStatusEnum.LOCKED.getCode());
				user.setLockTime(new Date());
				userService.save(user);
				RedisUtil.delete(key);
				throw new ExcessiveAttemptsException();
			}
		}
		
		
		boolean matches = super.doCredentialsMatch(token, info);
        if (matches){
        	RedisUtil.delete(key);
        }else{
        	RedisUtil.set(key, count);
        }
        return matches;
	}
	
	private String key(String loginName){
		return SUFFIX + loginName;
	}

}
