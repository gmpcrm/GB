import random

path = "c:\\Users\\jonson\\Dropbox\\Projects\\GB\\Lesson 5" 
file = "polynomial.txt"
filename = path + "\\" + file

k = 0
while k < 1:
    k = int(input("Задайте натуральную степень (целое число > 0):"))

str = (" ".join(
[v[0] + " " + v[1] for v in list(filter(lambda v: len(v[0]) > 0,
[("" + (str(v[0]) + ("*" if v[1] > 0 else "") if v[0] > 0 else "") + ("x" if v[1] > 0 else "") 
+ ("^" + str(v[1]) if v[1] > 1 else "") if v[0] else "", 
("+" if random.randrange(0,2) else "-")) 
for v in [(random.randrange(0,100), k - value) for value in range(0, k + 1)]]))]
).replace(" 1*x", " x"))[:-1] + "= 0"

print(str)
with open(filename, 'a') as f:
    f.write(str)
    f.write("\n")
