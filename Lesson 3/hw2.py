n = 0
while n < 1:
    print("Введите значение > 0:")
    n = int(input())

def calc(count):
    result = 1
    for value in range(1, count + 1):
        result = result*value
    return result

def calcrange(count):
    result = []
    for value in range(count):
        result.append(calc(value + 1))
    return result

r = calcrange(n)
print(r)
