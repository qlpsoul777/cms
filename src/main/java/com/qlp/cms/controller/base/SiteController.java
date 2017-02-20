package com.qlp.cms.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qlp.cms.constant.CmsConstant;
import com.qlp.cms.entity.base.Site;
import com.qlp.cms.service.base.SiteService;
import com.qlp.core.annotation.PageRequestParam;
import com.qlp.core.enums.StatusEnum;
import com.qlp.core.page.Page;
import com.qlp.core.page.Pageable;
import com.qlp.core.util.AssertUtil;
import com.qlp.core.web.WebUtil;

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
	
	/**
	 * 编辑站点信息
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,@RequestParam(value = "id", required = false) Long id){
		Site site = siteService.newIfNotFound(id);
		request.setAttribute("statuss", StatusEnum.values());
		request.setAttribute("site", site);
		return "/cms/site/edit";
	}
	
	/**
	 * 保存站点信息
	 * @param request
	 * @param site
	 * @return
	 */
	@RequestMapping("/save")
	public String save(@ModelAttribute Site site){
		siteService.save(site);
		return "redirect:list";
	}
	
	/**
	 * 批量删除站点信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/batchDel")
	@ResponseBody
	public void batchDel(HttpServletResponse response,@RequestParam(value = "ids") String ids){
		WebUtil.responseJson(response, siteService.deleteByIds(ids));
	}
	
	/**
	 * 站点管理
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/manager/{id}")
	public String manager(HttpServletRequest request,@PathVariable("id") Long id){
		Site site = siteService.queryById(id);
		
		AssertUtil.assertNotNull(site, "未查询到站点信息");
		request.getSession().setAttribute(CmsConstant.SITE_KEY, site);
		
		
		return "/cms/site/manager";
	}

}
