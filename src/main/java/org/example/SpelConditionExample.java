package org.example;

import java.math.BigDecimal;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelConditionExample {

  private ExpressionParser parser;

  public SpelConditionExample() {
    this.parser = new SpelExpressionParser();
  }

  public BigDecimal calculate(String expression) {
    return parser.parseExpression(expression).getValue(BigDecimal.class);
  }

  public static void main(String[] args) {

    ExpressionParser parser = new SpelExpressionParser();
    StandardEvaluationContext context = new StandardEvaluationContext();

    BigDecimal insurancePart = new BigDecimal("12.55");
    context.setVariable("insurancePart", insurancePart);


    context.setVariable("x", parser.parseExpression("2 - 3 * 4").getValue(context, BigDecimal.class));
    context.setVariable("y", parser.parseExpression("#x + 5").getValue(context,BigDecimal.class));
    context.setVariable("z", parser.parseExpression("#y != -5 ? 100 : 200 + #insurancePart").getValue(context,BigDecimal.class));


    BigDecimal x = (BigDecimal) context.lookupVariable("x");
    BigDecimal y = (BigDecimal) context.lookupVariable("y");
    BigDecimal z = (BigDecimal) context.lookupVariable("z");


    System.out.println(x);
    System.out.println(y);
    System.out.println(z);

//    BigDecimal xValue = (BigDecimal) context.lookupVariable("x");
//    System.out.println(xValue);
//
//    context.setVariable("xx", parser.parseExpression("#insurancePart").getValue(BigDecimal.class));
//    BigDecimal xxValue = (BigDecimal) context.lookupVariable("xx");
//    System.out.println("xx"+xxValue);
//
//
//    BigDecimal insurancePartx = parser.parseExpression("#insurancePart + #x").getValue(context, BigDecimal.class);
//    System.out.println("insurancePart "+ insurancePartx);
//
//    BigDecimal yValue = parser.parseExpression("#y = #x + (2 - 3) * 4.25/5").getValue(context, BigDecimal.class);
//    System.out.println(yValue);
//
//
//
//    // 1. Literal expression
//    Expression expression;
//
//    // 6. Ternary operator
//    expression = parser.parseExpression("#x != null ? 'xsome value' : 'default'");
//    String strVal = expression.getValue(String.class);
//    System.out.println( strVal);
//
//    // 7. Elvis operator
//    expression = parser.parseExpression("'some value' ?: 'default'");
//    strVal = expression.getValue(String.class);
//    System.out.println( strVal);
//
//
//    context.setVariable("x", parser.parseExpression("2 - 3 * 4").getValue(BigDecimal.class));
//
//
//    BigDecimal res = parser.parseExpression("#x").getValue(BigDecimal.class);
//    System.out.println(res);

  }
}