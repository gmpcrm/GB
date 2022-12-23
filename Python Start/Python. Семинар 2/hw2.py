def calc(count):
    result = 1
    for value in range(1, count + 1):
        result *= value
    return result

def calcrange(count):
    return [calc(value + 1) for value in range(count)]

n = 0
while n < 1:
    n = int(input("Введите целое число > 0:"))

print(calcrange(n))
