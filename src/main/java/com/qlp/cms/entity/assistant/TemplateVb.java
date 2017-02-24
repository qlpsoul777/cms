package com.qlp.cms.entity.assistant;

import com.qlp.core.entity.BaseEntity;

/**
 * 模板变量实体(T_CMS_ASSISTANT_TEMPLATEVB)
 * @author qlp
 *
 */
public class TemplateVb extends BaseEntity{

	private static final long serialVersionUID = 103865721993106331L;
	
	private String vbKey;			//变量key值
	private String vbValue;			//变量value值
	private String description;		//描述
	
	private Long siteId;			//所属站点id

	public String getVbKey() {
		return vbKey;
	}

	public void setVbKey(String vbKey) {
		this.vbKey = vbKey;
	}

	public String getVbValue() {
		return vbValue;
	}

	public void setVbValue(String vbValue) {
		this.vbValue = vbValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

}
