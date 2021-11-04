package zkt.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GetConstructor {

	public static void main(String[] args) {
		try {
			// 调用该类的无参public构造函数来创建实例
			PersonCons pc = PersonCons.class.newInstance();
			pc.toString();

			Constructor<?> cons1 = Integer.class.getConstructor(int.class);
			Integer n1 = (Integer) cons1.newInstance(101);
			System.out.println(n1);

			Constructor<?> cons2 = Integer.class.getConstructor(String.class);
			Integer n2 = (Integer) cons2.newInstance("100");
			System.out.println(n2);

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}

class PersonCons {
	public String name;
	public int age;
	public String gender;

	PersonCons() {
		name = "Smith";
		age = 18;
		gender = "male";
	}

	PersonCons(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String toString() {
		System.out.println(name + "," + age + "," + gender + ".");
		return name + "," + age + "," + gender;
	}

}