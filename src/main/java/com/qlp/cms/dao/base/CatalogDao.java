package com.qlp.cms.dao.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qlp.cms.entity.base.Catalog;

public interface CatalogDao {
	
	Long saveCatalog(Catalog catalog);
	
	Integer deleteById(Long id);
	
	Integer updateCatalog(Catalog catalog);
	
	Catalog queryById(Long id);

	List<Catalog> queryBySiteId(@Param("siteId") Long siteId,@Param("type") Integer type);
}
