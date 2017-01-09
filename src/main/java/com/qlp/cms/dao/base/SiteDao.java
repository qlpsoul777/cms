package com.qlp.cms.dao.base;

import java.util.List;

import com.qlp.cms.entity.base.Site;
import com.qlp.core.page.Pageable;

public interface SiteDao {
	
	Long saveSite(Site site);
	
	Integer deleteById(Long id);
	
	Integer updateSite(Site site);
	
	List<Site> queryPageList(Pageable<Site> pageable);

	Site queryById(Long id);
}
