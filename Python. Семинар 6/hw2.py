from string import whitespace, digits

class InvalidParse(Exception):
    pass

class EvaluationError(Exception):
    pass


class InvalidNumber(Exception):
    pass


class InvalidOperator(Exception):
    pass


class UnbalancedParens(Exception):
    pass


def cast(value):
    if isinstance(value, (int, float)):
        return value

    try:
        return int(value)
    except ValueError:
        pass

    try:
        return float(value)
    except ValueError:
        pass

    raise InvalidNumber(value)

def calculate(expr):
    ops = {
        '+': lambda x,y: x+y,
        '-': lambda x,y: x-y,
        '*': lambda x,y: x*y,
        '/': lambda x,y: x/y,
        '^': lambda x,y: x**y
    }

    precedence = list(ops.values())
    digitsc = digits + '.'

    def evaluate(tokens):
        stack = []
        for token in tokens:
            if callable(token):
                b, a = cast(stack.pop()), cast(stack.pop())
                result = token(a, b)
                stack.append(result)
            else:
                if token.endswith('.'):
                    raise InvalidNumber(token)
                stack.append(token)

        if len(stack) > 1:
            raise EvaluationError(str(stack))

        return stack[0]

    def parse(expr):
        tokens = []
        stack = []

        last = None
        for c in expr:
            if c in whitespace:
                last = c
            elif c in digits:
                value = str(c)
                if last and last in digitsc:
                    value = tokens.pop() + value

                last = c
                tokens.append(value)
            elif c == '.':
                if last and last in digits:
                    last = c
                    tokens.append(tokens.pop() + ".")
                else:
                    raise InvalidParse("Неправильное число")
            elif c == '(':
                last = c
                stack.append('(')
            elif c == ')':
                last = c
                if not stack:
                    raise UnbalancedParens(c)

                while stack:
                    cur = stack.pop()
                    if isinstance(cur, str) and cur == '(':
                        break
                    else:
                        tokens.append(cur)
            else:
                op = ops.get(c, None)
                if op is None:
                    raise InvalidOperator(c)

                if not tokens and c in '+-':
                    tokens.append('0')

                while stack:
                    cur = stack[-1]
                    if isinstance(cur, str) and cur == '(':
                        break
                    elif precedence.index(cur) < precedence.index(op):
                        break
                    tokens.append(stack.pop())

                stack.append(op)
                last = c

        while stack:
            op = stack.pop()
            if isinstance(op, str) and op == '(':
                raise UnbalancedParens()
            tokens.append(op)

        return tokens

    tokens = parse(expr)
    result = evaluate(tokens)
    return result

def example(s):
    #return calculate(s)
    return s

print('Простой калькулятор 1.0')
print('Примеры использования:')
print(example("2/3 * 7.15 + 10")) # 14.76
print(example("14^3-(25*(6+7)/2))")) # 2581.5
print(example("7*36-3+123+(1-3)+5+(7/5*25+11-(1-2)/3)")) # 421.33
print(example("7 * 7 + (8 - 111) / (6 + 23 / 20 ^ 2 * (10 + 9))")) # 34.47

s = input('Введите арифметическое выражение (можно использовать +-/*^ скобки и .):')
try:
    print(calculate(s))
except InvalidParse as e:
    print("Ошибка. Неправильный синтаксис:", e)
except EvaluationError as e:
    print("Ошибка. Неправильное выражение:", e)
except InvalidNumber as e:
    print("Ошибка. Неправильное число:", e)
except InvalidOperator as e:
    print("Ошибка. Неправильный оператор:", e)
except UnbalancedParens:
    print("Ошибка. Неправильные скобки")

