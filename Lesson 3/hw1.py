str = input("Введите число:")

result = 0
for value in str:
    if value.isdigit():
        result += int(value)

print(result)
