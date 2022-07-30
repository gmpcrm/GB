str = input("Введите число:")
#str = "123.456789"

#оптимизация
result = sum(map(int,filter(lambda c: c.isdigit(), str)))

# result = 0
# for value in str:
#     if value.isdigit():
#         result += int(value)

print(result)
