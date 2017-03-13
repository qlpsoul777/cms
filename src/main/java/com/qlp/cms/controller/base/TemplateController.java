package com.qlp.cms.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qlp.cms.constant.CmsConstant;
import com.qlp.cms.entity.base.Site;
import com.qlp.cms.entity.base.Template;
import com.qlp.cms.enums.TemplateTypeEnum;
import com.qlp.cms.service.base.CatalogService;
import com.qlp.cms.service.base.TemplateService;
import com.qlp.core.annotation.PageRequestParam;
import com.qlp.core.enums.StatusEnum;
import com.qlp.core.page.Page;
import com.qlp.core.page.Pageable;

@Controller
@RequestMapping(value = "/template")
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;
	
	@Autowired
	private CatalogService catalogService;
	
	@SuppressWarnings({"unchecked" })
	@PageRequestParam
	@RequestMapping("/list")
	public String list(HttpServletRequest request,@ModelAttribute Template template,Long catalogId){
		Pageable<Template> pageable =  (Pageable<Template>) request.getAttribute("pageable");
		Page<Template> pageInfo = templateService.queryPage(pageable);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("catalogId", catalogId);
		return "/cms/template/list";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "catalogId", required = true) Long catalogId){
		Template template = templateService.newIfNotFound(id);
		template.setCatalogId(catalogId);
		
		request.setAttribute("template", template);
		request.setAttribute("statuss", StatusEnum.values());
		request.setAttribute("types", TemplateTypeEnum.values());
		return "/cms/template/edit";
	}
	
	@RequestMapping("/save")
	public String save(HttpServletRequest request,@ModelAttribute Template template){
		
		Site site = (Site) request.getSession().getAttribute(CmsConstant.SITE_KEY);
		template.setSiteId(site.getId());
		
		templateService.save(template);
		return "redirect:list?catalogId="+template.getCatalogId();
	}
	
}
