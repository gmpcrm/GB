def calculate(data):
    print('Список:', data)
    result = []
    count = len(data)
    for idx in range(int(count/2)):
        result.append(data[idx] * data[-idx - 1])

    if count % 2 == 1:
        idx = int(count/2)
        result.append(data[idx] * data[idx])

    print('Произведение пар чисел списка:', result)    
    return result

calculate([2, 3, 5, 6])
calculate([2, 3, 4, 5, 6])
