text = "абыр абыр абырабвалг фывапролдж зимбабве анадысь внутре нейронка абвера"
print("Оригинальный текст:", text)

result = " ".join(list(filter(lambda x: "абв" not in x, text.split(" "))))
print("Текст без абв:", result)