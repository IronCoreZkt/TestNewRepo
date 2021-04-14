package zkt.spring.test;

public class VariableParamTest {

	public static void main(String[] args) {
		String[] sl = new String[] { "a", "b", "c" };
		test(sl);
		test("d", "e");
		test();
		test(new String[] { "f", "g", "h" });
	}

	public static void test(String... params) {
		for (String param : params) {
			System.out.print(param);
		}
		if (params.length > 0) {
			System.out.println();
		}
	}

}
