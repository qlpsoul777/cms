package com.qlp.cms.entity.expanse;

import com.qlp.core.entity.IdEntity;

/**
 * 广告组实体(T_CMS_EXPANSE_ADVERTGROUP)
 * @author qlp
 *
 */
public class AdvertGroup extends IdEntity {
	
	private static final long serialVersionUID = 3552068727939787410L;
	
	private String name;	//广告组名
	private String mark;	//组标识
	private Integer status;	//状态
	
	private Long siteId;	//所属站点id

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	

}
