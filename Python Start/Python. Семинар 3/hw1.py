count = int(input("Задайте количество элементов > 0:"))
data = list(range(1, count + 1))
print('Список элементов:', data)

result = sum(data[idx] for idx in range(1, count, 2))
print('Сумма элементов списка, стоящих на нечётной позиции:', result)
