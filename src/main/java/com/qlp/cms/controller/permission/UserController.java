package com.qlp.cms.controller.permission;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qlp.cms.entity.permission.User;
import com.qlp.cms.service.permission.UserService;

import com.qlp.core.annotation.PageRequestParam;
import com.qlp.core.page.Page;
import com.qlp.core.page.Pageable;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings({"unchecked" })
	@PageRequestParam
	@RequestMapping("/list")
	public String list(HttpServletRequest request,@ModelAttribute User user){
		Pageable<User> pageable =  (Pageable<User>) request.getAttribute("pageable");
		Page<User> pageInfo = userService.queryPage(pageable);
		request.setAttribute("user", user);
		request.setAttribute("pageInfo", pageInfo);
		return "/cms/user/list";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,@RequestParam(value = "id", required = false) Long id){
		User user = userService.newIfNotFound(id);
		request.setAttribute("user", user);
		return "/cms/User/edit";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute User user){
		userService.save(user);
		return "redirect:list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(HttpServletRequest request,@PathVariable("id") Long id){
		userService.deleteById(id);
		return "redirect:list";
	}

}
