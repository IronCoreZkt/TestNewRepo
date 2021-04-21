package zkt.spring.lifeCycle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class PlayerFactory implements FactoryBean<PlayerAction>, InitializingBean, DisposableBean {
	private PlayerAction target;
	private PlayerAction proxyObj;

	public PlayerAction getTarget() {
		return target;
	}

	public void setTarget(PlayerAction target) {
		this.target = target;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destory");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("AfterPropertiesSet");
		proxyObj = (PlayerAction) Proxy.newProxyInstance(this.getClass().getClassLoader(),
				new Class[]{Class.forName("zkt.spring.lifeCycle.PlayerAction")},
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("method:" + method.getName());
						System.out.println("observe");
						Object result = method.invoke(target, args);
						System.out.println("run and follow the ball");
						return result;
					}
			
		});
	}

	@Override
	public PlayerAction getObject() throws Exception {
		System.out.println("getObject");
		return proxyObj;
	}

	@Override
	public Class<?> getObjectType() {
		return proxyObj != null ? proxyObj.getClass() : Object.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
