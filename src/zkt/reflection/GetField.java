package zkt.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class GetField {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		String className = Student.class.getName();
		System.out.println(className);
		Class<?> stdClass = Class.forName("zkt.reflection.GetField$Student");
		System.out.println(stdClass.getField("name"));
		System.out.println(stdClass.getField("grade"));
		System.out.println(stdClass.getDeclaredField("score"));
		
		Field f = String.class.getDeclaredField("value");
		f.getName();
		f.getType();
		int m = f.getModifiers();
		System.out.println(Modifier.isAbstract(m));//false
		System.out.println(Modifier.isFinal(m));//true
		System.out.println(Modifier.isPrivate(m));//true
		System.out.println(Modifier.isProtected(m));//false
		System.out.println(Modifier.isPublic(m));//false
		System.out.println(Modifier.isStatic(m));//false
		
		Student p = new Student();
		p.setScore(99);
		Class c = p.getClass();
		Field f1 = c.getDeclaredField("score");
		f1.setAccessible(true);
		System.out.println(f1.get(p));
		f1.set(p, 100);
		System.out.println(p.getScore());
	}

	static class Student extends Person {
		private int score;
		public int grade;
		protected int address;
		
		public int getScore() {
			return score;
		}
		
		public void setScore(int score) {
			this.score = score;
		}
	}
}


class Person {
	public String name;
}