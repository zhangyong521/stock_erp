package com.zy.cache;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author 17616
 */
@Component
public class SpringUtil implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext act) throws BeansException {
		applicationContext=act;
	}
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	
	public static <T> T getBean(Class<T> cls) {
		return applicationContext.getBean(cls);
	}

}
