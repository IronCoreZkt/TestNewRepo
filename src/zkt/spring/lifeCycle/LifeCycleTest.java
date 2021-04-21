package zkt.spring.lifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("LifeCycleTestBeans.xml");
		Object obj1 = ctx.getBean("playerfactory");
		Object obj2 = ctx.getBean("&playerfactory");
		System.out.println("ctx.getBean(\"playerfacory\"):" + obj1.getClass().getName());
		System.out.println("ctx.getBean(\"&playerfacory\"):" + obj2.getClass().getName());
		System.out.println("-----------------------");

		PlayerAction someone = ctx.getBean("playerfactory", PlayerAction.class);
		someone.shoot();
		System.out.println();
		someone.pass();
		((ConfigurableApplicationContext) ctx).close();
	}

}
