package com.qlp.cms.entity.permission;

import java.util.Date;

import com.qlp.core.entity.IdEntity;

/**
 * 用户实体(t_cms_permission_User)
 * @author qlp
 *
 */
public class User extends IdEntity {

	private static final long serialVersionUID = 6456860774589801855L;

	private String loginName; 			// 登录名
	private String password; 			// 密码
	private String name; 				// 真实姓名
	private String email; 				// 邮箱地址
	private String phoneNum; 			// 联系方式
	private String address; 			// 联系地址
	private String imgPath; 			// 头像地址
	private String salt; 				// 加盐值（用作加密解密用）
	
	private Integer status; 			// 状态
	private Integer sex;				// 性别
	
	private Date lockTime;				//锁定时间

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}
	
	

}
