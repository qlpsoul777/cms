package com.qlp.cms.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qlp.cms.entity.base.Template;
import com.qlp.cms.service.base.TemplateService;

import com.qlp.core.annotation.PageRequestParam;
import com.qlp.core.page.Page;
import com.qlp.core.page.Pageable;

@Controller
@RequestMapping(value = "/template")
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;
	
	@SuppressWarnings({"unchecked" })
	@PageRequestParam
	@RequestMapping("/list")
	public String list(HttpServletRequest request,@ModelAttribute Template template){
		Pageable<Template> pageable =  (Pageable<Template>) request.getAttribute("pageable");
		Page<Template> pageInfo = templateService.queryPage(pageable);
		request.setAttribute("template", template);
		request.setAttribute("pageInfo", pageInfo);
		return "/cms/template/list";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,@RequestParam(value = "id", required = false) Long id){
		Template template = templateService.newIfNotFound(id);
		request.setAttribute("template", template);
		return "/cms/Template/edit";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Template template){
		templateService.save(template);
		return "redirect:list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(HttpServletRequest request,@PathVariable("id") Long id){
		templateService.deleteById(id);
		return "redirect:list";
	}

}
