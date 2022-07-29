text = "абыр абыр абырвалг фывапролдж зимбабве анадысь внутре нейронка абвера"
result = " ".join(list(filter(lambda x: "абв" not in x, text.split(" "))))

print(text)
print(result)