package com.qlp.cms.dao.base;

import java.util.List;

import com.qlp.cms.entity.base.Catalog;

import com.qlp.core.page.Pageable;

public interface CatalogDao {
	
	Long saveCatalog(Catalog catalog);
	
	Integer deleteById(Long id);
	
	Integer updateCatalog(Catalog catalog);
	
	List<Catalog> queryPageList(Pageable<Catalog> pageable);

	Catalog queryById(Long id);
}
