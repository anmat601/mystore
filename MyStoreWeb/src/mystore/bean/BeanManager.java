package mystore.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import MyStoreWeb.ItemServlet;

public class BeanManager implements ApplicationContextAware{
	private static ApplicationContext context;
	final static Logger logger = LogManager.getLogger(BeanManager.class);
	public static ApplicationContext getContext()
	{
		
		return context;

	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		logger.debug("debug called");
		context =arg0;
		
	}

}
