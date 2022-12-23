def calculate(data):
    print('Список:', data)
    count = len(data)
    result = [data[idx] * data[-idx - 1] for idx in range(int(count/2))]
    if count % 2 == 1:
        result.append(data[int(count/2)] ** 2)
    print('Произведение пар чисел списка:', result)
    return result

calculate([2, 3, 5, 6])
calculate([2, 3, 4, 5, 6])
