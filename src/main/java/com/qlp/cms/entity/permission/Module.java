package com.qlp.cms.entity.permission;

import com.qlp.core.entity.IdEntity;

/**
 * 权限资源实体(T_CMS_PERMISSION_MODULE)
 * @author qlp
 *
 */
public class Module extends IdEntity {

	private static final long serialVersionUID = 4384247145152144557L;
	
    private String name;   			//模块名
    private String permission;  	//权限关键字
    private String url;  			//链接地址
    private String description;  	//描述
    
    private Integer sort;  			//排序字段
    private Integer level;  		//层级
    private Integer type;  			//类型
    private Integer status;  		//是否启用
    
    private Long pId;  				//父模块
    
    

}
