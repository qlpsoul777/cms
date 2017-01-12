package com.qlp.cms.controller.base;

import java.util.List;

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
import com.qlp.cms.entity.base.Catalog;
import com.qlp.cms.entity.base.Site;
import com.qlp.cms.service.base.CatalogService;
import com.qlp.core.annotation.PageRequestParam;
import com.qlp.core.enums.ContentTypeEnum;
import com.qlp.core.enums.StatusEnum;
import com.qlp.core.page.Page;
import com.qlp.core.page.Pageable;
import com.qlp.core.util.AssertUtil;
import com.qlp.core.web.WebUtil;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	
	/**
	 * 栏目管理栏目树
	 * @param request
	 * @return
	 */
	@RequestMapping("/tree")
	@ResponseBody
	public void tree(HttpServletRequest request,HttpServletResponse response){
		Site site = (Site) request.getSession().getAttribute(CmsConstant.SITE_KEY);
		AssertUtil.assertNotNull(site,"无法从session中获取站点信息");
		List<Catalog> CatalogTree = catalogService.queryCatalogTree(site);
		WebUtil.responseJson(response, CatalogTree);
	}
	
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
	
	
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,@RequestParam(value = "id", required = false) Long id){
		Catalog catalog = catalogService.newIfNotFound(id);
		request.setAttribute("catalog", catalog);
		return "/cms/Catalog/edit";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Catalog catalog){
		catalogService.save(catalog);
		return "redirect:list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(HttpServletRequest request,@PathVariable("id") Long id){
		catalogService.deleteById(id);
		return "redirect:list";
	}

}
