package com.qlp.cms.entity.sys;

import java.util.Date;

import com.qlp.core.entity.BaseEntity;

/**
 * 错误日志记录(T_CMS_SYS_ERRORLOG)
 * @author qlp
 *
 */
public class ErrorLog extends BaseEntity {
	
	private static final long serialVersionUID = 4149055146721119275L;
	
	private Long id;			//主键id
	private String type;		//错误类型
	private String detail;		//错误详情
	private String errFrom;		//错误信息来源
	private Date errTime;		//错误触发时间
	
	private Long siteId;		//所属站点id,如果为空说明是主站的数据

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getErrFrom() {
		return errFrom;
	}

	public void setErrFrom(String errFrom) {
		this.errFrom = errFrom;
	}

	public Date getErrTime() {
		return errTime;
	}

	public void setErrTime(Date errTime) {
		this.errTime = errTime;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	
}
