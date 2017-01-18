package com.qlp.cms.service.permission;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlp.cms.entity.permission.User;
import com.qlp.core.util.RedisUtil;

public class RetryPasswordCount extends HashedCredentialsMatcher{
	
	private static int limit = 3;  //密码重试次数限制，默认为3次，可通过配置文件修改次数限制数
	private static final String SUFFIX = "RetryPasswordCountCache:";
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
		boolean matches = super.doCredentialsMatch(token, info);
        if (!matches){
        	String loginName = (String) token.getPrincipal();
        	AtomicInteger count = (AtomicInteger) RedisUtil.get(key(loginName));
    		if(count ==null){
    			RedisUtil.set(key(loginName), new AtomicInteger(0));
    		}
    		if(count.incrementAndGet() > limit){
    			User user = userService.findByLoginName(loginName);
    			if(user != null){
    				//TODO 
    			}
    		}
    		
        }
        return matches;
	}
	
	private String key(String loginName){
		return SUFFIX + loginName;
	}

}
