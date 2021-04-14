package zkt.spring.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zkt.spring.depConf.OrderCollection;

public class CollectionBeanConfigTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("collectionBeans.xml");
		OrderCollection orderCollection = ctx.getBean("orderCollection", OrderCollection.class);
		orderCollection.print();
		((ConfigurableApplicationContext) ctx).close();
	}

}
