package com.qlp.cms.entity.base;

import com.qlp.core.entity.IdEntity;

/**
 * 模板实体(T_CMS_BASE_TEMPLATE)
 * @author qlp
 *
 */
public class Template extends IdEntity {

	private static final long serialVersionUID = 3725869095560258159L;
	
	private String name;				//模板名称
	
	private Integer type;				//模板类型
	
	private String path;				//发布路径
	
	private Integer sort;				//排序字段
	
	private Integer status;				//模板状态
	
	private String content;				//模板内容
	
	private String introduction;		//模板说明
	
	private Long catalogId;				//所属栏目id
	
	private Long siteId;				//所属站点id

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Long getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	
}
