wd = 0
while wd < 1 or wd > 7:
    wd = int(input("Введите день недели от 1 до 7:"))

print("да" if 5 < wd < 8 else "нет")