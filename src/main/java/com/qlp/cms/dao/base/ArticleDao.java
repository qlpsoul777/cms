package com.qlp.cms.dao.base;

import java.util.List;

import com.qlp.cms.entity.base.Article;

import com.qlp.core.page.Pageable;

public interface ArticleDao {
	
	Long saveArticle(Article article);
	
	Integer deleteById(Long id);
	
	Integer updateArticle(Article article);
	
	List<Article> queryPageList(Pageable<Article> pageable);

	Article queryById(Long id);
}
