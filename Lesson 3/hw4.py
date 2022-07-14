count = 0
while count < 1:
    count = int(input("Задайте количество элементов > 0:"))

data = list(range(-count, count + 1))
size = len(data)

print(data)
print("Задайте через пробел позиции в списке (от 1 до " + str(size) + "):")
positions = input().split(" ")

result = 1
for value in positions:
    idx = int(value)
    if 0 < idx <= size:
        result *= data[idx - 1]

print(result)
