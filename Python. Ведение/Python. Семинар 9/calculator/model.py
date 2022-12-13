from string import whitespace, digits

ERROR_MSG = "ERROR"

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

def evaluate_expression(expression):
    try:
        result = str(calculate(expression))
    except Exception:
        result = ERROR_MSG
    return result

def create_model():
    return evaluate_expression
