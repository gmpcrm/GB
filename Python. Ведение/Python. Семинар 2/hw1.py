import decimal
data = decimal.Decimal(input("Введите вещественное число:"))
#data = decimal.Decimal("12345.456781234123412349")
#data = decimal.Decimal("0.123456")

result = sum(data.as_tuple()[1])
print(result)
