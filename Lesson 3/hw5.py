import time

count = 0
while count < 1:
    count = int(input("Задайте количество элементов > 0:"))

data = list(range(1, count + 1))
print(data)

rand = int((time.time_ns() / 1073676287))

for i in range(len(data)):
    j = rand % (i + 1)
    data[i],data[j] = data[j],data[i]

print(data)