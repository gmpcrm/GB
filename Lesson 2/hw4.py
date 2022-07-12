r = 0
while r < 1 or r > 4:
    print("Введите значение четверти от 1 до 4:")
    r = int(input())

match r:
    case 1:
        print("x > 0 and y > 0")
    case 2:
        print("x < 0 and y > 0")
    case 3:
        print("x < 0 and y < 0")
    case 4:
        print("x > 0 and y < 0")
