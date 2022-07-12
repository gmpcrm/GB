print("Введите координату x первой точки:")
x1 = int(input())

print("Введите координату y первой точки:")
y1 = int(input())

print("Введите координату x второй точки:")
x2 = int(input())

print("Введите координату y второй точки:")
y2 = int(input())

result = round(((x2 - x1)**2 + (y2 - y1)**2)**0.5, 2)
print(f"{result:.2f}")
