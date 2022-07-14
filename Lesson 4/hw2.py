def calc(data):
    result = []
    count = len(data)
    for idx in range(int(count/2)):
        result.append(data[idx] * data[-idx - 1])

    if count % 2 == 1:
        idx = int(count/2)
        result.append(data[idx] * data[idx])
    
    return result

print(calc([2, 3, 5, 6]))
print(calc([2, 3, 4, 5, 6]))
