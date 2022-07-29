import random

k = 0
while k < 1 or k > 32:
    k = int(input("Задайте число от 1 до 32:"))

nums = sorted([random.randrange(0, k) for value in range(0, 32)])
print(nums)

result = [val for val in nums if nums.count(val) == 1]
print(result)
