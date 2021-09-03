package zkt.reflection;

/**
 * @ClassName: GetClassInfo
 * @Description: https://www.liaoxuefeng.com/wiki/1252599548343744/1264799402020448
 * @author: zkt
 * @date: 2021年8月17日下午3:51:57
 *
 */
public class GetClassInfo {

	public static void main(String[] args) throws ClassNotFoundException {
		printClassInfo("".getClass());
		printClassInfo(Runnable.class);
		printClassInfo(java.time.Month.class);
		printClassInfo(String[].class);
		printClassInfo(int[].class);
		printClassInfo(int.class);
		printClassInfo(Class.class);
		printClassInfo(Class.forName("java.lang.String"));
		ClassInstanceIsSame();
	}

	@SuppressWarnings("rawtypes")
	static void printClassInfo(Class cls) {
		System.out.println("Class's name:\t\t" + cls.getName());
		System.out.println("Class's simple name:\t" + cls.getSimpleName());
		if (cls.getPackage() != null) {
			System.out.println("Package's name:\t\t" + cls.getPackage().getName());
		}
		System.out.println("is interface/接口类型?\t" + cls.isInterface());
		System.out.println("is enum/枚举类型?\t" + cls.isEnum());
		System.out.println("is array/数组类型?\t" + cls.isArray());
		System.out.println("is primitive/基本类型？\t" + cls.isPrimitive());
		System.out.println("---");
	}
	
	@SuppressWarnings("rawtypes")
	static void ClassInstanceIsSame(){
		Class cls1 = String.class;

		String s = "Hello";
		Class cls2 = s.getClass();

		boolean sameClass = cls1 == cls2; // true
		System.out.println(sameClass);
		
		Integer n = new Integer(123);

		boolean b1 = n instanceof Integer; // true，因为n是Integer类型
		System.out.println(b1);
		boolean b2 = n instanceof Number; // true，因为n是Number类型的子类
		System.out.println(b2);
		Class cls3 = n.getClass();
		boolean b3 = cls3 == Integer.class; // true，因为n.getClass()返回Integer.class
		System.out.println(b3);
		boolean b4 = cls3 == Number.class; // false，因为Integer.class!=Number.class
		System.out.println(b4);
	}

}
