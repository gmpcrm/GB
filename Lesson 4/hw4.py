n = int(input("Введите число:"))

result = ""
while n > 0:
    result = ("1" if n % 2 else "0") + result
    n //= 2

if len(result) == 0:
    result = "0"

print(result)
