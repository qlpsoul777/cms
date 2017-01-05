package com.qlp.cms.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qlp.cms.entity.base.Site;
import com.qlp.cms.service.base.SiteService;
import com.qlp.core.annotation.PageRequestParam;
import com.qlp.core.page.Page;
import com.qlp.core.page.Pageable;

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
	@SuppressWarnings({"unchecked" })
	@PageRequestParam
	@RequestMapping("/list")
	public String list(HttpServletRequest request,@ModelAttribute Site site){
		Pageable<Site> pageable =  (Pageable<Site>) request.getAttribute("pageable");
		Page<Site> pageInfo = siteService.queryPage(pageable);
		request.setAttribute("site", site);
		request.setAttribute("pageInfo", pageInfo);
		return "/cms/site/list";
	}

}
