package com.qlp.cms.service.base;

import java.util.List;

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
	public void deleteById(Long id) {
		catalogDao.deleteById(id);
	}

	public String queryCatalogTree(Site site) {
		List<Catalog> catalogs = catalogDao.queryBySiteId(site.getId());
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", 0L);
		jsonObj.put("name", site.getName());
		jsonObj.put("pid", null);
		jsonArray.add(jsonObj);
		if(CollectionUtil.isNotBlank(catalogs)){
			for (Catalog catalog : catalogs) {
				jsonObj = new JSONObject();
				jsonObj.put("id", catalog.getId());
				jsonObj.put("name", catalog.getName());
				jsonObj.put("pid", catalog.getpId());
				jsonArray.add(jsonObj);
			}
		}
		String result = jsonArray.toString();
		LogUtil.info(logger, "栏目管理栏目树json数据：{0}", result);
		return result;
	}

	@Transactional(readOnly = false)
	public String save(Long pId, Catalog catalog, Site site) {
		catalog.setSiteId(site.getId());
		catalog.setpId(pId);
		
		Catalog parent = catalogDao.queryById(pId);
		String path = null;
		if(parent == null){
			path = CmsConstant.OVER_CHAR + site.getNum() + CmsConstant.OVER_CHAR + catalog.getAlias();
		}else{
			path = parent.getPath() + CmsConstant.OVER_CHAR + catalog.getAlias();
		}
		LogUtil.info(logger, "根据站点信息、父级栏目信息、栏目别名获取栏目路径为:{0}", path);
		catalog.setPath(path);
		
		LogUtil.info(logger, "待持久化参数catalog:{0}", catalog);
		if(site.getId() != null){
			catalogDao.updateCatalog(catalog);
		}else{
			catalogDao.saveCatalog(catalog);
		}
		return JSONObject.toJSONString(new MsgInfo(true));
	}

}
