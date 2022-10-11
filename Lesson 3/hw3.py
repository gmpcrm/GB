str = input("Введите строку:")
#astr1 = "абыр абыр абырвалг фывапролдж зимбабве абыр анадысь абыр внутре абыр нейронка абвера"

substr = input("Введите подстроку:")
#str2 = "абыр"

result = len(list(filter(lambda v: v == substr, str.split(" "))))
print(result)