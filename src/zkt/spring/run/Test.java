package zkt.spring.run;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zkt.spring.start.Order;


public class Test {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Order order = ctx.getBean("order", Order.class);
		order.paySuccess();
		ctx.close();
	}
}
