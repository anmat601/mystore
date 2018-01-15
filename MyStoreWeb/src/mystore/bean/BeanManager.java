package mystore.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanManager {
	private static ApplicationContext context;

	public static ApplicationContext getContext()
	{
		if(null==context)
		{
			context =new ClassPathXmlApplicationContext("Beans.xml");
		}
		return context;

	}

}
