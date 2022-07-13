n = 0
while n < 1:
    print("Введите целое число > 0:")
    n = int(input())

nums = {}
for idx in range(1, n + 1):
    nums[idx] = (1 + 1/idx)**idx

result = 0
for value in nums.values():
    result += value

print(f"{result:.2f}")