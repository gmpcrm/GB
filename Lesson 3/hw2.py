n = 0
while n < 1:
    n = int(input("Введите значение > 0:"))

def calc(count):
    result = 1
    for value in range(1, count + 1):
        result *= value
    return result

def calcrange(count):
    result = []
    for value in range(count):
        result.append(calc(value + 1))
    return result

r = calcrange(n)
print(r)
