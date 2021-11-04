package zkt.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
	// 动态代理是通过Proxy创建代理对象，然后将接口方法“代理”给InvocationHandler完成的
	public static void main(String[] args) {
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("调用反射的方法：" + method);
				if(method.getName().equals("morning")){
					System.out.println("good morning, " + args[0]);
				}
				return null;
			}
		};
		Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), 
				new Class[]{Hello.class}, 
				handler);
		hello.morning("Louis");
	}
}

interface Hello{
	void morning(String name);
}

class HelloDynamicProxy implements Hello {
	InvocationHandler handler;

	public HelloDynamicProxy(InvocationHandler handler) {
		this.handler = handler;
	}

	@Override
	public void morning(String name) {
		try {
			handler.invoke(this, Hello.class.getMethod("morning", String.class), new Object[]{name});
		} catch (NoSuchMethodException|SecurityException e) {
			System.out.println(e.getMessage());
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}