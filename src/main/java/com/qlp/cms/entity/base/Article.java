package com.qlp.cms.entity.base;

import java.util.Date;

import com.qlp.core.entity.IdEntity;

public class Article extends IdEntity {

	private static final long serialVersionUID = -1213034903356315788L;
	
	private String title;				//新闻标题
	private String subTitle;			//副标题
	private String referName;			//指定名称
	private String url;					//访问地址
	private String articleSource;		//文章来源
	private String author;				//文章作者
	private String tagValue;			//TAG标签
	private String metaKeyword;			//SEO关键字
	private String introduction;		//简介
	private String content;				//内容
	
	private Date publishTime;			//发布时间
	private Date checkTime;				//审核时间
	
	private Integer type;				//类型(1:普通新闻2：链接新闻3：附件新闻)
	private Integer isRefer;			//是否指定名称(0:不需要，1:需要)
	private Integer logicStatus;		//逻辑状态(0:无效/已删除,1:有效)
	private Integer sort;				//排序字段
	private Integer needDiscuss;		//是否允许评论(0:禁止，1:允许)
	private Integer needCheck;			//是否需要审核：(0:不需要，1:需要)
	private Integer status;				//文章状态(待提交，待审核，驳回，待发布，已发布)
	
	private Long viewNum;				//浏览次数
	private Long catalogId;				//所属栏目id
	private Long siteId;				//所属站点id
	
	
	private Catalog catalog;			//所属栏目
	private Site site;					//所属站点
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getReferName() {
		return referName;
	}
	public void setReferName(String referName) {
		this.referName = referName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getArticleSource() {
		return articleSource;
	}
	public void setArticleSource(String articleSource) {
		this.articleSource = articleSource;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTagValue() {
		return tagValue;
	}
	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}
	public String getMetaKeyword() {
		return metaKeyword;
	}
	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getIsRefer() {
		return isRefer;
	}
	public void setIsRefer(Integer isRefer) {
		this.isRefer = isRefer;
	}
	public Integer getLogicStatus() {
		return logicStatus;
	}
	public void setLogicStatus(Integer logicStatus) {
		this.logicStatus = logicStatus;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getNeedDiscuss() {
		return needDiscuss;
	}
	public void setNeedDiscuss(Integer needDiscuss) {
		this.needDiscuss = needDiscuss;
	}
	public Integer getNeedCheck() {
		return needCheck;
	}
	public void setNeedCheck(Integer needCheck) {
		this.needCheck = needCheck;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getViewNum() {
		return viewNum;
	}
	public void setViewNum(Long viewNum) {
		this.viewNum = viewNum;
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
	public Catalog getCatalog() {
		return catalog;
	}
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
}
