package com.qlp.july.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang3.StringUtils;

import com.qlp.july.cache.GlobalCache;
import com.qlp.july.enums.EnvironmentEnum;

public class StartupInitializer implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		GlobalCache.env = event.getServletContext().getInitParameter("spring.profiles.default");
		String path = event.getServletContext().getRealPath(File.separator);
		if(StringUtils.equals(GlobalCache.env, EnvironmentEnum.DEPLOY.getCode())){
			path = event.getServletContext().getInitParameter("dataPath");
		}
		GlobalCache.dataPath = path;
		
	}

}
