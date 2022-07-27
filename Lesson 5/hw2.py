n = 0
while n < 1:
    n = int(input("Введите число больше 0:"))

result = []
d = 2
while d * d <= n:
    if n % d == 0:
        result.append(d)
        n //= d
    else:
        d += 1
        
if n > 1:
    result.append(n)

print(result)