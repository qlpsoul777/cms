package com.qlp.cms.controller.permission;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qlp.cms.entity.permission.User;
import com.qlp.cms.filter.CaptchaValidateFilter;
import com.qlp.cms.service.permission.UserService;
import com.qlp.core.annotation.PageRequestParam;
import com.qlp.core.exception.MyException;
import com.qlp.core.page.Page;
import com.qlp.core.page.Pageable;
import com.qlp.core.util.SecurityUtil;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String first(){
		SecurityUtil.logout();
        return "/cms/user/login";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request){
		String msg = "";//登录提示信息
        String errorClassName = (String)request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if(CaptchaValidateFilter.ERROR_MSG.equals(errorClassName)){
            msg = "验证码错误";
        }else if(UnknownAccountException.class.getName().equals(errorClassName)){
            msg = "用户名/密码错误";
        }else if(IncorrectCredentialsException.class.getName().equals(errorClassName)){
            msg = "用户名/密码错误";
        }else if(LockedAccountException.class.getName().equals(errorClassName)){
            msg ="用户被锁定";
        }else if(ExcessiveAttemptsException.class.getName().equals(errorClassName)){
            msg ="登录次数过多";
        }else if(errorClassName != null){
            msg = "登录出错";
        }
        request.setAttribute("msg", msg);
		return "/cms/user/login";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request){
		
    	String loginName = SecurityUtil.getCurrentUserLoginName();
    	User user = userService.findByLoginName(loginName);
    	request.setAttribute("user",user);
        return "/cms/user/index";
    }

}
