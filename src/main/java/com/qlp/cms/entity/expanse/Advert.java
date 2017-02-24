package com.qlp.cms.entity.expanse;

import java.util.Date;

import com.qlp.core.entity.IdEntity;

/**
 * 广告实体(T_CMS_EXPANSE_ADVERT)
 * @author qlp
 *
 */
public class Advert extends IdEntity {
	
	private static final long serialVersionUID = -5226512994307486647L;
	
	private String title;				//广告标题
	private String imgPath;				//图片路径
	private String linkUrl;				//链接地址
	private String openWay;				//打开方式
	private String description;			//描述
	
	private Integer advertWidth;		//展示图片宽度
	private Integer advertHeight;		//展示图片高度
	private Integer sort;				//排序
	private Integer timeLimit;			//是否指定有效期范围
	private Integer status;				//状态
	
	private Date startTime;				//开始时间
	private Date endTime;				//结束时间
	
	private Long groupId;				//所属广告组id
	private Long siteId;				//所属站点id
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getOpenWay() {
		return openWay;
	}
	public void setOpenWay(String openWay) {
		this.openWay = openWay;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAdvertWidth() {
		return advertWidth;
	}
	public void setAdvertWidth(Integer advertWidth) {
		this.advertWidth = advertWidth;
	}
	public Integer getAdvertHeight() {
		return advertHeight;
	}
	public void setAdvertHeight(Integer advertHeight) {
		this.advertHeight = advertHeight;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	
	

}
