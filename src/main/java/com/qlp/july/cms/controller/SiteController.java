package com.qlp.july.cms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qlp.july.cms.entity.Site;
import com.qlp.july.cms.service.SiteService;
import com.qlp.july.core.annotation.PageRequestParam;

/**
 * 站点管理controller
 * @author july
 *
 */
@Controller
@RequestMapping(value = "/site")
public class SiteController {
	
	@Autowired
	private SiteService siteService;
	
	/**
	 * 站点列表
	 * @param request
	 * @param site
	 * @return
	 */
	@PageRequestParam
	@RequestMapping("/list")
	public String list(HttpServletRequest request,@ModelAttribute Site site){
		
		request.setAttribute("site", site);
		return "/cms/site/list";
	}

}
