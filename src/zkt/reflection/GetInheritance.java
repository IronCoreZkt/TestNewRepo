package zkt.reflection;

import java.io.Closeable;

public class GetInheritance {

	public static void main(String[] args) {
		// 获取父类的Class
		Class<Integer> ic = Integer.class;
		Class<?> nc = ic.getSuperclass();
		System.out.println("Integer父类Class：" + nc);
		Class<?> oc = nc.getSuperclass();
		System.out.println("Number父类Class：" + oc);
		System.out.println("Object父类Class：" + oc.getSuperclass());

		// 获取当前类实现的interface（不包括父类实现的接口）
		Class<?>[] iics = ic.getInterfaces();
		for (Class<?> iic : iics) {
			System.out.println("Integer实现的接口Class：" + iic);
		}
		
		Class<?>[] nics = nc.getInterfaces();
		for (Class<?> nic : nics) {
			System.out.println("Number实现的接口Class：" + nic);
		}
		
		// 对所有接口的Class对象调用getSuperclass返回的是Null，获取接口的父接口要用getInterfaces
		Class<Closeable> cc = java.io.Closeable.class;
		System.out.println(cc.getSuperclass());
		Class<?>[] ccis = cc.getInterfaces();
		for (Class<?> cci : ccis) {
			System.out.println("Closeable实现的接口Class：" + cci);
		}
		
		// 判断是否是某个类型
		Object o = Integer.valueOf(123);
		System.out.println(o instanceof Double); // flase
		System.out.println(o instanceof Number); // true
		System.out.println(o instanceof java.io.Serializable); // true
		// 判断是否可以上转型
		Number.class.isAssignableFrom(Integer.class);// true，Integer可以赋值给Number
		Integer.class.isAssignableFrom(Number.class);// false，Number不能赋值给Integer
	}

}
