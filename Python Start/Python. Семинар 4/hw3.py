import random

filename = "files\polynomial.txt"

k = 0
while k < 1:
    k = int(input("Задайте натуральную степень (целое число > 0):"))

coefficients = [(random.randrange(0, 100), k - value) for value in range(0, k + 1)]
filtered_coefficients = list(filter(lambda v: v[0] != 0, coefficients))

polynomial_str = " ".join([f"{v[0]}x^{v[1]}" if v[1] > 1 else f"{v[0]}x" if v[1] == 1 else f"{v[0]}" for v in filtered_coefficients])
polynomial_str += "= 0"

print('Многочлен степени k:', polynomial_str)

# Записываем строку в файл
with open(filename, 'a') as f:
    f.write(polynomial_str)
    f.write("\n")
