print("Введите день недели")
wd = int(input())

if wd == 6 or wd == 7:
    print("Выходной")
elif wd > 0 and wd < 6:
    print("Рабочий день")
else:
    print("Неправильный ввод")