package com.qlp.cms.entity.base;

import com.qlp.core.entity.IdEntity;

/**
 * 站点实体(T_CMS_SITE)
 * @author qlp
 *
 */
public class Site extends IdEntity {
	
	private static final long serialVersionUID = 3463163092681044525L;

	private String name;			//站点名称
	
	private String num;				//站点编号
	
	private Integer status;			//站点状态
	
	private String path;			//站点访问路径
	
	private String introduction;	//站点简介
	
	private String imgPath;			//站点封面

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
}
