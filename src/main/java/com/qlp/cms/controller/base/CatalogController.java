package com.qlp.cms.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qlp.cms.entity.base.Catalog;
import com.qlp.cms.service.base.CatalogService;

import com.qlp.core.annotation.PageRequestParam;
import com.qlp.core.page.Page;
import com.qlp.core.page.Pageable;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	@SuppressWarnings({"unchecked" })
	@PageRequestParam
	@RequestMapping("/list")
	public String list(HttpServletRequest request,@ModelAttribute Catalog catalog){
		Pageable<Catalog> pageable =  (Pageable<Catalog>) request.getAttribute("pageable");
		Page<Catalog> pageInfo = catalogService.queryPage(pageable);
		request.setAttribute("catalog", catalog);
		request.setAttribute("pageInfo", pageInfo);
		return "/cms/catalog/list";
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
