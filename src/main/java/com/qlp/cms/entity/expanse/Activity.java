package com.qlp.cms.entity.expanse;

import com.qlp.core.entity.IdEntity;

/**
 * 活动实体(T_CMS_EXPANSE_ACTIVITY)
 * @author qlp
 *
 */
public class Activity extends IdEntity {

	private static final long serialVersionUID = -8524862947506150728L;
	
	private String name;			//活动名称
	private String mark;			//活动标识
	private String introduction;	//活动简介
	
	private Long siteId;			//所属站点id

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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

}
