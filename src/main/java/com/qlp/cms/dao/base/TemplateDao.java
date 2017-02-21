package com.qlp.cms.dao.base;

import java.util.List;

import com.qlp.cms.entity.base.Template;

import com.qlp.core.page.Pageable;

public interface TemplateDao {
	
	Long saveTemplate(Template template);
	
	Integer deleteById(Long id);
	
	Integer updateTemplate(Template template);
	
	List<Template> queryPageList(Pageable<Template> pageable);

	Template queryById(Long id);
}
