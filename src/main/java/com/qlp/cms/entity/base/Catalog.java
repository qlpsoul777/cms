package com.qlp.cms.entity.base;

import java.util.List;

import com.qlp.core.entity.IdEntity;
import com.qlp.core.enums.StatusEnum;

public class Catalog extends IdEntity{

	private static final long serialVersionUID = 6146737328227401680L;
	
	private String name;				//栏目名
	
	private String alias;				//栏目别名
	
	private StatusEnum status;			//栏目状态
	
	private String introduction;		//栏目描述
	
	private String path;				//访问路径
	
	private String contentType;			//内容类型
	
	private Integer isLeaf;				//是否是叶子结点
	
	private Integer sort;				//排序字段
	
	private String imgPath;				//封面图片
	
	private Long siteId;				//所属站点
	
	private Long pId;					//父级栏目
	
	private List<Catalog> children;		//子栏目

}
