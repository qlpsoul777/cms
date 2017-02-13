package com.qlp.cms.entity.base;

import java.util.List;

import com.qlp.core.entity.IdEntity;
import com.qlp.core.enums.ContentTypeEnum;

public class Catalog extends IdEntity{

	private static final long serialVersionUID = 6146737328227401680L;
	
	private String name;				//栏目名
	
	private String alias;				//栏目别名
	
	private Integer status;				//栏目状态
	
	private String introduction;		//栏目描述
	
	private String path;				//访问路径
	
	private ContentTypeEnum contentType;//内容类型
	
	private Integer sort;				//排序字段
	
	private String imgPath;				//封面图片
	
	private Long siteId;				//所属站点
	
	private Long pId;					//父级栏目
	
	private List<Catalog> children;		//子栏目

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ContentTypeEnum getContentType() {
		return contentType;
	}

	public void setContentType(ContentTypeEnum contentType) {
		this.contentType = contentType;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public List<Catalog> getChildren() {
		return children;
	}

	public void setChildren(List<Catalog> children) {
		this.children = children;
	}
	
}
