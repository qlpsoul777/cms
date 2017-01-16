package com.qlp.cms.dao.permission;

import java.util.List;

import com.qlp.cms.entity.permission.User;

import com.qlp.core.page.Pageable;

public interface UserDao {
	
	Long saveUser(User user);
	
	Integer deleteById(Long id);
	
	Integer updateUser(User user);
	
	List<User> queryPageList(Pageable<User> pageable);

	User queryById(Long id);
}
