package com.qlp.cms.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qlp.cms.constant.CmsConstant;
import com.qlp.cms.entity.base.Article;
import com.qlp.cms.entity.base.Site;
import com.qlp.cms.service.base.ArticleService;
import com.qlp.core.annotation.PageRequestParam;
import com.qlp.core.page.Page;
import com.qlp.core.page.Pageable;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@SuppressWarnings({"unchecked" })
	@PageRequestParam
	@RequestMapping("/list")
	public String list(HttpServletRequest request,@ModelAttribute Article article,Long catalogId){
		
		Pageable<Article> pageable =  (Pageable<Article>) request.getAttribute("pageable");
		
		Page<Article> pageInfo = articleService.queryPage(pageable);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("catalogId", catalogId);
		return "/cms/article/list";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "catalogId", required = true) Long catalogId){
		Article article = articleService.newIfNotFound(id);
		article.setCatalogId(catalogId);
		
		request.setAttribute("article", article);
		return "/cms/article/edit";
	}
	
	@RequestMapping("/save")
	public String save(HttpServletRequest request,@ModelAttribute Article article){
		Site site = (Site) request.getSession().getAttribute(CmsConstant.SITE_KEY);
		article.setSiteId(site.getId());
		articleService.save(article);
		return "redirect:list?catalogId="+article.getCatalogId();
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(HttpServletRequest request,@PathVariable("id") Long id){
		articleService.deleteById(id);
		return "redirect:list";
	}

}
