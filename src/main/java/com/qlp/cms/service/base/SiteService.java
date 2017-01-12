package com.qlp.cms.service.base;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlp.cms.dao.base.SiteDao;
import com.qlp.cms.entity.base.Site;
import com.qlp.core.entity.MsgInfo;
import com.qlp.core.page.Page;
import com.qlp.core.page.PageImpl;
import com.qlp.core.page.Pageable;
import com.qlp.core.util.LogUtil;
import com.qlp.core.util.StringUtil;

/**
 * 站点管理服务层
 * @author qlp
 *
 */
@Service("siteService")
@Transactional(readOnly = true)
public class SiteService {
	
	private static final Logger logger = LoggerFactory.getLogger(SiteService.class);

	@Autowired
	private SiteDao siteDao; 
	
	public Page<Site> queryPage(Pageable<Site> pageable) {
		List<Site> sites = siteDao.queryPageList(pageable);
		Page<Site> page = new PageImpl<>(sites, pageable);
		return page;
	}
	
	public Site queryById(Long id){
		LogUtil.info(logger, "接收到Site的参数id:{0}", id);
		Site site = siteDao.queryById(id);
		LogUtil.info(logger, "通过参数id:{0}-查询到的结果site:{1}", id,site);
		return site;
	}

	public Site newIfNotFound(Long id) {
		if(id == null){
			return new Site();
		}
		return queryById(id);
	}

	@Transactional(readOnly = false)
	public void save(Site site) {
		LogUtil.info(logger, "待保存的Site:{0}", site);
		if(site.getId() != null){
			siteDao.updateSite(site);
		}else{
			siteDao.saveSite(site);
		}
	}

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		siteDao.deleteById(id);
	}

	@Transactional(readOnly = false)
	public MsgInfo deleteByIds(String ids) {
		LogUtil.info(logger, "待删除ids:{0}", ids);
		MsgInfo info = new MsgInfo(true);
		if(StringUtils.isNotBlank(ids)){
			Long[] id = StringUtil.toLongArray(ids,",");
			try {
				siteDao.deleteByIdIn(id);
			} catch (Exception e) {
				LogUtil.error(logger, "批量删除失败:{0}",e);
				info = new MsgInfo(false,"批量删除失败");
			}
		}
		return info;
	}
}
