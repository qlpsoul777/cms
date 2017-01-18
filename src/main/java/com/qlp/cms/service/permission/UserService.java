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
	
	public Page<User> queryPage(Pageable<User> pageable) {
		List<User> list = userDao.queryPageList(pageable);
		Page<User> page = new PageImpl<>(list, pageable);
		return page;
	}
	
	public User queryById(Long id){
		User user = userDao.queryById(id);
		return user;
	}

	public User newIfNotFound(Long id) {
		if(id == null){
			return new User();
		}
		return queryById(id);
	}

	@Transactional(readOnly = false)
	public void save(User user) {
		userDao.saveUser(user);
	}

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		userDao.deleteById(id);
	}

	public Set<String> findRolesByLoginName(String loginName) {
		
		return null;
	}

	public User findByLoginName(String loginName) {
		
		return userDao.findByLoginName(loginName);
	}

}
