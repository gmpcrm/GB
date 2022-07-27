import time

k = 0
while k < 1 or k > 20:
    k = int(input("Задайте число от 1 до 20:"))

nums = [(time.time_ns() >> value) & k for value in range(1, 64)]

print(nums)
print(set(nums))
