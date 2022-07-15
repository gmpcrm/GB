count = 0
while count < 1:
    count = int(input("Задайте количество элементов > 0:"))

data = list(range(1, count + 1))
print(data)

result = 0
for idx in range(1, count, 2):
    result += data[idx]

print(result)
