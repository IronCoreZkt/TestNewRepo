package zkt.spring.test;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpringELTest {

	public static void main(String[] args) {
		// 1. 构建解析器
		ExpressionParser parser = new SpelExpressionParser();
		// 2. 解析表达式
		Expression exp = parser.parseExpression("'Messi'.toUpperCase()");
		// 3. 获取结果
		System.out.println(exp.getValue());
	}

}
