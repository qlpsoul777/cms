package com.qlp.cms.dao.permission;

import com.qlp.cms.entity.permission.User;

public interface UserDao {
	
	User findByLoginName(String loginName);
}
