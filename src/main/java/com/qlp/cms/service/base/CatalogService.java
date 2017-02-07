package com.qlp.cms.service.base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlp.cms.dao.base.CatalogDao;
import com.qlp.cms.entity.base.Catalog;

import com.qlp.core.page.Page;
import com.qlp.core.page.PageImpl;
import com.qlp.core.page.Pageable;
import com.qlp.core.util.LogUtil;

@Service("catalogService")
@Transactional(readOnly = true)
public class CatalogService {
	
	private static final Logger logger = LoggerFactory.getLogger(CatalogService.class);

	@Autowired
	private CatalogDao catalogDao; 
	
	public Catalog queryById(Long id){
		Catalog catalog = catalogDao.queryById(id);
		return catalog;
	}

	public Catalog newIfNotFound(Long id) {
		if(id == null){
			return new Catalog();
		}
		return queryById(id);
	}

	@Transactional(readOnly = false)
	public void save(Catalog catalog) {
		catalogDao.saveCatalog(catalog);
	}

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		catalogDao.deleteById(id);
	}

}
