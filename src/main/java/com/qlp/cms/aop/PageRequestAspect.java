package com.qlp.cms.aop;


import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.qlp.core.annotation.PageRequestParam;
import com.qlp.core.page.PageRequest;
import com.qlp.core.page.Pageable;
import com.qlp.core.page.Sort;
import com.qlp.core.util.DataConvertUtil;
import com.qlp.core.util.LogUtil;

/**
 * 分页查询参数转换切面，拦截controller中的分页请求方法，将请求参数转化成Pageable<T>
 * 	特殊要求：1、被拦截的方法必须使用注解@PageRequestParam。
 * 		   2、被拦截的方法第一个参数必须是HttpServletRequest,第二个参数必须是@ModelAttribute T t。
 * @author qlp
 *
 */
@Aspect
@Component
public class PageRequestAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(PageRequestAspect.class);
	
	@Pointcut("execution(public * com.qlp.cms.controller.*..*Controller.list(..))")
	public void pageCovert(){}
	
	@Before(value = "pageCovert() && @annotation(annotation) &&args(object,..)",argNames="annotation,object")
	public void covertToPageable(JoinPoint pj, PageRequestParam annotation, Object object) throws Throwable{
		long start = System.currentTimeMillis();
		
		Object[] o = pj.getArgs();
		HttpServletRequest request = (HttpServletRequest) o[0];
		
		int pageSize = DataConvertUtil.toInt(request.getParameter("pageSize"), annotation.size());
		int	currentPage = DataConvertUtil.toInt(request.getParameter("currentPage"));	
		
		Sort sort = null;
		if(annotation.isSort()){
			Enumeration<String> params = request.getAttributeNames();
			String key;
			Object value;
			
			while(params.hasMoreElements()){
				key = params.nextElement();
				if(key.endsWith("_sort")){
					
					value = request.getParameter(key);
					
				}
			}
		}
		
		Pageable<?> pageable = new PageRequest<>(pageSize,currentPage,sort,o[1]);
		request.setAttribute(annotation.name(), pageable);
		
		long end = System.currentTimeMillis();
		
		LogUtil.info(logger, "组装分页查询条件耗时：{0}毫秒,组装后的结果：{1}", end-start,pageable);
	}

}
