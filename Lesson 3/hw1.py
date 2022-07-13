print("Введите число:")
str = input()

result = 0
for value in str:
    if value.isdigit():
        result += int(value)

print(result)
