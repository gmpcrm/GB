str = input("Введите вещественное число:")
#str = "123.456789"

result = sum(map(int,filter(lambda c: c.isdigit(), str)))
print(result)
