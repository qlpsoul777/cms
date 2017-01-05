package com.qlp.cms.service.base;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlp.cms.dao.base.SiteDao;
import com.qlp.cms.entity.base.Site;
import com.qlp.core.page.Page;
import com.qlp.core.page.PageImpl;
import com.qlp.core.page.PageRequest;
import com.qlp.core.page.Pageable;

/**
 * 站点管理服务层
 * @author qlp
 *
 */
@Service("siteService")
@Transactional(readOnly = true)
public class SiteService {
	
	private static final Logger logger = LoggerFactory.getLogger(SiteService.class);

	@Resource
	private SiteDao siteDao; 
	
	public Page<Site> queryPage(Pageable<Site> pageable) {
		List<Site> sites = siteDao.queryPageList(pageable);
		Page<Site> page = new PageImpl<>(sites, pageable);
		return page;
	}


}
