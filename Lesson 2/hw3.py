x = 0
while x == 0:
    print("Введите значение x не равное 0")
    x = int(input())

y = 0
while y == 0:
    print("Введите значение y не равное 0")
    y = int(input())

if x > 0 and y > 0:
    print(1)
elif x < 0 and y > 0:
    print(2)
elif x < 0 and y < 0:
    print(3)
elif x > 0 and y < 0:
    print(4)
