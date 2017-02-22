package com.qlp.cms.service.base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlp.cms.dao.base.TemplateDao;
import com.qlp.cms.entity.base.Template;
import com.qlp.core.page.Page;
import com.qlp.core.page.PageImpl;
import com.qlp.core.page.Pageable;

@Service("templateService")
@Transactional(readOnly = true)
public class TemplateService {
	
	private static final Logger logger = LoggerFactory.getLogger(TemplateService.class);

	@Autowired
	private TemplateDao templateDao; 
	
	public Page<Template> queryPage(Pageable<Template> pageable) {
		List<Template> list = templateDao.queryPageList(pageable);
		Page<Template> page = new PageImpl<>(list, pageable);
		return page;
	}
	
	public Template queryById(Long id){
		Template template = templateDao.queryById(id);
		return template;
	}

	public Template newIfNotFound(Long id) {
		if(id == null){
			return new Template();
		}
		return queryById(id);
	}

	@Transactional(readOnly = false)
	public void save(Template template) {
		templateDao.saveTemplate(template);
	}

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		templateDao.deleteById(id);
	}

}
