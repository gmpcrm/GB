import time

k = 0
while k < 1 or k > 32:
    k = int(input("Задайте число от 1 до 32:"))

nums = [(time.time_ns() >> value) & k for value in range(1, 64)]
print(nums)

result = list(set(nums))
print(result)
