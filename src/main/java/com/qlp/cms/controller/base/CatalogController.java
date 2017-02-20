package com.qlp.cms.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qlp.cms.constant.CmsConstant;
import com.qlp.cms.entity.base.Catalog;
import com.qlp.cms.entity.base.Site;
import com.qlp.cms.service.base.CatalogService;
import com.qlp.cms.service.base.SiteService;
import com.qlp.core.annotation.PageRequestParam;
import com.qlp.core.enums.ContentTypeEnum;
import com.qlp.core.enums.StatusEnum;
import com.qlp.core.exception.ErrorDetail.SysErrorEnum;
import com.qlp.core.page.Page;
import com.qlp.core.page.Pageable;
import com.qlp.core.util.AssertUtil;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	/**
	 * 栏目管理
	 * @param request
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request){
		request.setAttribute("statuss", StatusEnum.values());
		request.setAttribute("types", ContentTypeEnum.values());
		return "/cms/catalog/manager";
	}
	
	/**
	 * 栏目管理栏目树
	 * @param request
	 * @return
	 */
	@RequestMapping("/tree")
	@ResponseBody
	public String tree(HttpServletRequest request){
		Site site = (Site) request.getSession().getAttribute(CmsConstant.SITE_KEY);
		AssertUtil.assertNotNull(site, SysErrorEnum.DOMAIN_NOT_FOUND, "无法从session中获取站点信息");

		return catalogService.queryCatalogTree(site);
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,@RequestParam(value = "id", required = false) Long id){
		Catalog catalog = catalogService.newIfNotFound(id);
		request.setAttribute("catalog", catalog);
		return "/cms/Catalog/edit";
	}
	
	/**
	 * 保存栏目信息
	 * @param request
	 * @param catalog
	 * @param pId
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(HttpServletRequest request,@ModelAttribute Catalog catalog,Long pId){
		Site site = (Site) request.getSession().getAttribute(CmsConstant.SITE_KEY);
		AssertUtil.assertNotNull(site, SysErrorEnum.DOMAIN_NOT_FOUND, "无法从session中获取站点信息");
		
		return catalogService.save(pId,catalog,site);
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(HttpServletRequest request,@PathVariable("id") Long id){
		catalogService.deleteById(id);
		return "redirect:list";
	}

}
