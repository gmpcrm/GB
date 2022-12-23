data = [1.1, 1.2, 3.1, 5, 10.01]

fractions = [value % 1 for value in data]
min_fraction = min(fractions)
max_fraction = max(fractions)
result = max_fraction - min_fraction

print('Список из вещественных чисел:', data)
print(f"Разница между максимальным и минимальным значением дробной части элементов: {result:.2f}")