import random

k = 0
while k < 1 or k > 32:
    k = int(input("Задайте число от 1 до 32:"))

nums = [random.randrange(0, k) for value in range(0, 32)]
print(nums)

d = {}
for num in nums:
    d[num] = d.get(num, 0) + 1

print(d)

result = [val[0] for val in (filter(lambda x: x[1] == 1,d.items()))]
print(result)
