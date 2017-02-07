package com.qlp.cms.dao.base;

import com.qlp.cms.entity.base.Catalog;

public interface CatalogDao {
	
	Long saveCatalog(Catalog catalog);
	
	Integer deleteById(Long id);
	
	Integer updateCatalog(Catalog catalog);
	
	Catalog queryById(Long id);
}
