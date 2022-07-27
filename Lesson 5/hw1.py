import math

values = ["0." + "0" * value + "1" for value in range(0, 10)]

str = ""
while not str in values:
    print("Укажите точность π в виде:")
    print(*values, sep="\n")
    str = input()

fpi = round(math.pi, values.index(str) + 1)
print(fpi)
