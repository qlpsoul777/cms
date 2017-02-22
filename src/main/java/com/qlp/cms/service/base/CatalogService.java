package com.qlp.cms.service.base;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qlp.cms.constant.CmsConstant;
import com.qlp.cms.dao.base.CatalogDao;
import com.qlp.cms.entity.base.Catalog;
import com.qlp.cms.entity.base.Site;
import com.qlp.core.entity.MsgInfo;
import com.qlp.core.util.CollectionUtil;
import com.qlp.core.util.LogUtil;
import com.qlp.core.web.WebUtil;

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

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		catalogDao.deleteById(id);
	}

	public String queryCatalogTree(Site site,Integer type) {
		List<Catalog> catalogs = catalogDao.queryBySiteId(site.getId(),type);
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", 0L);
		jsonObj.put("pId", -1L);
		jsonObj.put("name", site.getName());
		jsonArray.add(jsonObj);
		if(CollectionUtil.isNotBlank(catalogs)){
			for (Catalog catalog : catalogs) {
				jsonObj = new JSONObject();
				jsonObj.put("id", catalog.getId());
				jsonObj.put("pId", catalog.getpId());
				jsonObj.put("name", catalog.getName());
				jsonArray.add(jsonObj);
			}
		}
		String result = jsonArray.toString();
		LogUtil.info(logger, "栏目管理栏目树json数据：{0}", result);
		return result;
	}

	@Transactional(readOnly = false)
	public void save(HttpServletResponse response,Catalog catalog, Site site) {
		catalog.setSiteId(site.getId());
		
		Catalog parent = catalogDao.queryById(catalog.getpId());
		String path = null;
		if(parent == null){
			path = CmsConstant.OVER_CHAR + site.getNum() + CmsConstant.OVER_CHAR + catalog.getAlias();
		}else{
			path = parent.getPath() + CmsConstant.OVER_CHAR + catalog.getAlias();
		}
		LogUtil.info(logger, "根据站点信息、父级栏目信息、栏目别名获取栏目路径为:{0}", path);
		catalog.setPath(path);
		
		LogUtil.info(logger, "待持久化参数catalog:{0}", catalog);
		if(catalog.getId() != null){
			catalogDao.updateCatalog(catalog);
		}else{
			catalogDao.saveCatalog(catalog);
		}
		
		WebUtil.responseJson(response, new MsgInfo(true));
	}

}
