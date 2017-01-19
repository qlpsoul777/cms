package com.qlp.cms.service.permission;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlp.cms.dao.permission.UserDao;
import com.qlp.cms.entity.permission.User;
import com.qlp.core.page.Page;
import com.qlp.core.page.PageImpl;
import com.qlp.core.page.Pageable;
import com.qlp.core.util.LogUtil;

@Service("userService")
@Transactional(readOnly = true)
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao; 
	
	public User findByLoginName(String loginName) {
		
		return userDao.findByLoginName(loginName);
	}

}
