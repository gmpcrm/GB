import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.BiFunction;

class InvalidParse extends Exception {
}

class EvaluationError extends Exception {
  public EvaluationError(String value) {
    super("Evaluation number: " + value);
  }
}

class InvalidNumber extends Exception {
  public InvalidNumber(String value) {
    super("Invalid number: " + value);
  }
}

class InvalidOperator extends Exception {
  public InvalidOperator(char c) {
    super("Invalid operator: " + c);
  }
}

class UnbalancedParens extends Exception {
  public UnbalancedParens() {
    super("Unbalanced parentheses");
  }

  public UnbalancedParens(char c) {
    super("Unbalanced parentheses: " + c);
  }
}

class Calculator {
  public static double cast(Object value) throws InvalidNumber {
    if (value instanceof Integer || value instanceof Double) {
      return (double) value;
    }

    try {
      return Integer.parseInt((String) value);
    } catch (NumberFormatException e) {
    }

    try {
      return Double.parseDouble((String) value);
    } catch (NumberFormatException e) {
    }

    throw new InvalidNumber((String) value);
  }

  public static double calculate(String expr)
      throws InvalidParse, UnbalancedParens, InvalidOperator, InvalidNumber, EvaluationError {      
    
    BiFunction<Double, Double, Double> add = (a, b) -> a + b;
    BiFunction<Double, Double, Double> sub = (a, b) -> a - b;
    BiFunction<Double, Double, Double> mul = (a, b) -> a * b;
    BiFunction<Double, Double, Double> div = (a, b) -> a / b;
    BiFunction<Double, Double, Double> pow = (a, b) -> Math.pow(a, b);

    Map<Character, BiFunction<Double, Double, Double>> ops = Map.of('+', add, '-', sub, '*', mul, '/', div, '^', pow);
    List<BiFunction<Double, Double, Double>> priority = new ArrayList<>(Arrays.asList(add, sub, mul, div, pow));
    
    Stack<Object> tokens = new Stack<>();
    Stack<Object> stack = new Stack<>();

    Character last = null;
    for (int i = 0; i < expr.length(); i++) {
      var c = expr.charAt(i);
      if (Character.isWhitespace(c)) {
        last = c;
      } else if (Character.isDigit(c) || c == '.') {
        var value = String.valueOf(c);
        if (last != null && (Character.isDigit(last) || last == '.')) {
          value = (String) tokens.pop() + value;
        }

        last = c;
        tokens.push(value);
      } else if (c == '(') {
        last = c;
        stack.push('(');
      } else if (c == ')') {
        last = c;
        if (stack.isEmpty()) {
          throw new UnbalancedParens(c);
        }

        while (!stack.isEmpty()) {
          var cur = stack.pop();
          if (cur.equals('(')) {
            break;
          } else {
            tokens.push(cur);
          }
        }
      } else {
        var op = ops.get(c);
        if (op == null) {
          throw new InvalidOperator(c);
        }

        if (tokens.isEmpty() && (c == '+' || c == '-')) {
          tokens.push("0");
        }

        while (!stack.isEmpty()) {
          var cur = stack.peek();
          if (cur.equals('(')) {
            break;
          } else if (priority.indexOf(cur) < priority.indexOf(op)) {
            break;
          }

          tokens.push(stack.pop());
        }

        stack.push(op);
        last = c;
      }
    }

    while (!stack.isEmpty()) {
      var op = stack.pop();
      if (op.equals('(')) {
        throw new UnbalancedParens();
      }

      tokens.push(op);
    }

    double result = 0;
    for (Object token : tokens) {
      if (token instanceof BiFunction) {
        double b = cast(stack.pop());
        double a = cast(stack.pop());
        result = ((BiFunction<Double, Double, Double>) token).apply(a, b);
        stack.push(result);
      } else {
        if (((String) token).endsWith(".")) {
          throw new InvalidNumber((String) token);
        }

        stack.push(token);
      }
    }

    if (stack.size() > 1) {
      throw new EvaluationError(stack.toString());
    }

    return (double) stack.get(0);
  }
}

class Example {
  public static String example(String s) throws InvalidParse, UnbalancedParens, InvalidOperator, InvalidNumber, EvaluationError {
      // return Double.toString(Calculator.calculate(s));
      return s;
  }

  public static void main(String[] args) {
    System.out.println("Простой калькулятор 1.0");
    System.out.println("Примеры использования:");

    Scanner scan = new Scanner(System.in);
    try {
      System.out.println(example("(2/3) * 7.15 + 10")); // 14.76
      System.out.println(example("14^3-(25*(6+7)/2))")); // 2581.5
      System.out.println(example("7*36-3+123+(1-3)+5+(7/5*25+11-(1-2)/3)")); // 421.33
      System.out.println(example("7 * 7 + (8 - 111) / (6 + 23 / 20 ^ 2 * (10 - 7))")); // 32.31

      System.out.print("Введите арифметическое выражение (можно использовать +-/*^ скобки и .):");
      String s = scan.nextLine();

      System.out.println(Calculator.calculate(s));
    } catch (InvalidParse e) {
      System.out.println("Ошибка. Неправильный синтаксис: " + e);
    } catch (EvaluationError e) {
      System.out.println("Ошибка. Неправильное выражение: " + e);
    } catch (InvalidNumber e) {
      System.out.println("Ошибка. Неправильное число: " + e);
    } catch (InvalidOperator e) {
      System.out.println("Ошибка. Неправильный оператор: " + e);
    } catch (UnbalancedParens e) {
      System.out.println("Ошибка. Неправильные скобки");
    } catch (Exception e) {
      System.out.println(e);
    }
    finally{
      scan.close();
    }
  }
}
