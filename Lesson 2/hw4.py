r = 0
while r < 1 or r > 4:
    print("Введите четверть от 1 до 4")
    r = int(input())

if r == 1:
    print("x > 0 and y > 0")
elif r == 2:
    print("x < 0 and y > 0")
elif r == 3:
    print("x < 0 and y < 0")
elif r == 4:
    print("x > 0 and y < 0")
