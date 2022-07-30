print("Введите день недели:")
wd = int(input())

#оптимизация
print("Выходной" if 5 < wd < 8 else "Рабочий день" if 0 < wd < 6 else "Неправильный ввод")

# if wd == 6 or wd == 7:
#     print("Выходной")
# elif wd > 0 and wd < 6:
#     print("Рабочий день")
# else:
#     print("Неправильный ввод")