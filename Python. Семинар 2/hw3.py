content = input("Введите строку:")
#content = "абыр абыр абырвалг фывапролдж зимбабве абыр анадысь абыр внутре абыр нейронка абвера"

substr = input("Введите подстроку:")
#substr = "абыр"

result = len(list(filter(lambda str: substr in str, content.split(" "))))
print(result)