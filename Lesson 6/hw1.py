import os
#text = "абыр абыр абырвалг фывапролдж зимбабве анадысь внутре нейронка абвера"

path = "c:\\Users\\jonson\\Dropbox\\Projects\\GB\\Lesson 6" 
file = "abcdata.txt"
filename = os.path.join(path, file)

text = ""
with open(filename, "r", encoding="utf-8") as f:
    text = f.read()
    result = " ".join(list(filter(lambda x: "абв" not in x, text.split(" "))))

print(text)
print(result)