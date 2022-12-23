data = [1.1, 1.2, 3.1, 5, 10.01]

def fmin(data):
    result = 0
    for value in data:
        f = value % 1
        if f > 0:
            if result == 0:
                result = f
            if result > f:
                result = f
    
    return result

def fmax(data):
    result = 0
    for value in data:
        f = value % 1
        if f > 0:
            if result == 0:
                result = f
            if f > result:
                result = f
    
    return result

print('Список из вещественных чисел:', data)
result = fmax(data) - fmin(data)
print(f"Разница между максимальным и минимальным значением дробной части элементов: {result:.2f}")