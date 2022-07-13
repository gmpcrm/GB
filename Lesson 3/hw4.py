count = 0
while count < 1:
    print("Задайте количество элементов > 0:")
    count = int(input())

data = list(range(-count, count + 1))
size = len(data)

print(data)
print("Задайте через пробел позиции в списке (от 1 до " + str(size) + "):")
positions = input().split(" ")

result = 1
for value in positions:
    index = int(value)
    if index > 0 and index <= size:
        result *= data[index - 1]

print(result)
