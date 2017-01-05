package com.qlp.cms.dao.base;

import java.util.List;

import com.qlp.cms.entity.base.Site;
import com.qlp.core.page.Pageable;

public interface SiteDao {
	
	List<Site> queryPageList(Pageable<Site> pageable);
}
