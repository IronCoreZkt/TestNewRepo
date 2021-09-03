package zkt.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetMethod {

	public static void main(String[] args) {
		Class<StudentMthd> stdClass = StudentMthd.class;
		try {
			StudentMthd sm = new StudentMthd();
			System.out.println(stdClass.getMethod("getScore"));
			System.out.println(stdClass.getMethod("getName"));
			Method setGrade = stdClass.getDeclaredMethod("setGrade", int.class);
			System.out.println(setGrade);
			sm.getGrade();
			setGrade.setAccessible(true);
			setGrade.invoke(sm, 6);
			sm.getGrade();

			String s = "reflect the world";
			Method substring = String.class.getMethod("substring", int.class);
			System.out.println(substring.invoke(s, 8));
			Method parseInt = Integer.class.getMethod("parseInt", String.class);
			System.out.println(parseInt.invoke(null, "123456"));
			
			Method polymorphicIndication = PersonMthd.class.getMethod("greetings");
			polymorphicIndication.invoke(sm);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}

class StudentMthd extends PersonMthd {
	int grade = 1;

	public int getScore() {
		return 99;
	}

	public int getGrade() {
		System.out.println(grade);
		return grade;
	}

	@SuppressWarnings("unused")
	private void setGrade(int year) {
		this.grade = year;
	}
	
	public void greetings(){
		System.out.println("Student:hello!");
	}

}

class PersonMthd {
	public String getName() {
		return "Person";
	}
	
	public void greetings(){
		System.out.println("Person:hello!");
	}
}
