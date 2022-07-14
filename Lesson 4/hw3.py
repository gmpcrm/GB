data = [1.1, 1.2, 3.1, 5, 10.01]

def min(data):
    result = 0
    for value in data:
        f = value % 1
        if f > 0:
            if result == 0:
                result = f
            if result > f:
                result = f
    
    return result

def max(data):
    result = 0
    for value in data:
        f = value % 1
        if f > 0:
            if result == 0:
                result = f
            if f > result:
                result = f
    
    return result

result = max(data) - min(data)
print(f"{result:.2f}")