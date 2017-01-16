package com.qlp.cms.entity.permission;

import com.qlp.core.entity.IdEntity;

public class Role extends IdEntity {

	private static final long serialVersionUID = -1339503459066808514L;
	
	private String name;  			//角色名称
    private String description;  	//角色描述

    private Integer status;  		//是否启用，默认为启用该角色
    private Integer type;			//角色类型
}
