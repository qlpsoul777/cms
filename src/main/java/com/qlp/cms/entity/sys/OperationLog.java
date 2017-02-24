package com.qlp.cms.entity.sys;

import java.util.Date;

import com.qlp.core.entity.BaseEntity;

/**
 * 系统操作日志记录(T_CMS_SYS_OPERATIONLOG)
 * @author qlp
 *
 */
public class OperationLog extends BaseEntity{

	private static final long serialVersionUID = -8481282940328774460L;
	
	private Long id;			//主键id
	private String type;		//操作类型
	private String description;	//操作描述
	private String opUser;		//操作人
	private Date opTime;		//操作时间
	private String ip;			//来源ip
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOpUser() {
		return opUser;
	}

	public void setOpUser(String opUser) {
		this.opUser = opUser;
	}

	public Date getOpTime() {
		return opTime;
	}

	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

}
