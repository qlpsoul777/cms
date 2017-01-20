package com.qlp.cms.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.AccessControlFilter;

public class CaptchaValidateFilter extends AccessControlFilter{
	
	public static final String ERROR_MSG = "captcha.error";
	
	private boolean captchaEbabled  = true;//是否开启验证码支持
    private  String captchaCodeKey = "captchaCode";//前台提交的验证码参数名
    private  String failureKeyAttribute = "shiroLoginFailure"; //验证码验证失败后存储到的属性名
    
    public void setCaptchaEbabled(boolean captchaEbabled) {
		this.captchaEbabled = captchaEbabled;
	}

	public  void setCaptchaCodeKey(String captchaCodeKey) {
		this.captchaCodeKey = captchaCodeKey;
	}

	public  void setFailureKeyAttribute(String failureKeyAttribute) {
		this.failureKeyAttribute = failureKeyAttribute;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest req,
			ServletResponse response, Object mappedValue) throws Exception {
    	
		HttpServletRequest request = (HttpServletRequest) req;
		
		//2、判断验证码是否禁用 或不是表单提交（允许访问）
        if (captchaEbabled == false || !"post".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
    	
    	String captchaCode = request.getParameter(captchaCodeKey);
    	String sessionCaptchaCode = (String) request.getSession().getAttribute(captchaCodeKey);
		request.getSession().removeAttribute(captchaCodeKey);
		
		return captchaCode.equals(sessionCaptchaCode);
	}
    
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		//如果验证码失败了，存储失败key属性
        request.setAttribute(failureKeyAttribute, ERROR_MSG);
        return true;
	}

}
