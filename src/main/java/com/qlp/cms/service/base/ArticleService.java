package com.qlp.cms.service.base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlp.cms.dao.base.ArticleDao;
import com.qlp.cms.entity.base.Article;

import com.qlp.core.page.Page;
import com.qlp.core.page.PageImpl;
import com.qlp.core.page.Pageable;
import com.qlp.core.util.LogUtil;

@Service("articleService")
@Transactional(readOnly = true)
public class ArticleService {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
	private ArticleDao articleDao; 
	
	public Page<Article> queryPage(Pageable<Article> pageable) {
		List<Article> list = articleDao.queryPageList(pageable);
		Page<Article> page = new PageImpl<>(list, pageable);
		return page;
	}
	
	public Article queryById(Long id){
		Article article = articleDao.queryById(id);
		return article;
	}

	public Article newIfNotFound(Long id) {
		if(id == null){
			return new Article();
		}
		return queryById(id);
	}

	@Transactional(readOnly = false)
	public void save(Article article) {
		articleDao.saveArticle(article);
	}

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		articleDao.deleteById(id);
	}

}
