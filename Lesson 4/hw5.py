count = 0
while count < 1:
    count = int(input("Введите количество > 0:"))

def fibo(n):
    if n in (0, 1):
        return n
    if n > 1:
        return fibo(n-1) + fibo(n-2)
    if n < 0:
        return int((-1)**(n+1)) * fibo(-n)

result = []
for num in range(-count, count + 1):
    result.append(fibo(num))

print(result)
