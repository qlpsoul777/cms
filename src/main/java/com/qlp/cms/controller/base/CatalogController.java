package com.qlp.cms.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qlp.cms.constant.CmsConstant;
import com.qlp.cms.entity.base.Catalog;
import com.qlp.cms.entity.base.Site;
import com.qlp.cms.service.base.CatalogService;
import com.qlp.core.entity.MsgInfo;
import com.qlp.core.enums.ContentTypeEnum;
import com.qlp.core.enums.StatusEnum;
import com.qlp.core.exception.ErrorDetail.SysErrorEnum;
import com.qlp.core.util.AssertUtil;
import com.qlp.core.web.WebUtil;

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
	
	@RequestMapping("/info")
	@ResponseBody
	public void info(HttpServletRequest request,HttpServletResponse response,@RequestParam(value = "id", required = true) Long id){
		Catalog catalog = catalogService.queryById(id);
		Catalog parent = catalogService.queryById(catalog.getpId());
		catalog.setParent(parent);
		WebUtil.responseJson(response, catalog);
	}
	
	/**
	 * 保存栏目信息
	 * @param request
	 * @param catalog
	 * @param pId
	 * @return
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ResponseBody
	public void save(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Catalog catalog){
		Site site = (Site) request.getSession().getAttribute(CmsConstant.SITE_KEY);
		AssertUtil.assertNotNull(site, SysErrorEnum.DOMAIN_NOT_FOUND, "无法从session中获取站点信息");
		
		catalogService.save(response,catalog,site);
	}
	
	@RequestMapping("/delete/{id}")
	public void delete(HttpServletRequest request,HttpServletResponse response,@PathVariable("id") Long id){
		catalogService.deleteById(id);
		WebUtil.responseJson(response, new MsgInfo(true));
	}

}
