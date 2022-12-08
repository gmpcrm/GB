import re

poly1 = "5*x^3 + 2*x^2 + 6"
poly2 = "7*x^2+6*x+3"
#result = "5*x^3 + 9*x^2 + 6*x + 9"

def normalize_string(str):    
    if len(str) > 0:
        return str.replace("\n", "").replace(" ", "").replace("*", "").replace("^", "").replace("=0","")
    else:
        return ""

def update_dictionary(d, str):
    s1 = re.split(r"\+", str)
    for value in s1:
        s = re.split(r"x", value)
        k = int(s[0])
        sf = s[1] if len(s) > 1 else "0"
        f = int(sf) if len(sf) > 0 else 1
        d[f] = d.get(f, 0) + k

d = {}
update_dictionary(d, normalize_string(poly1))
update_dictionary(d, normalize_string(poly2))
d = sorted(d.items(), reverse=True)

s = " + ".join(
    [str(v[1]) + ("*" + "x" if v[0] > 0 else "") + ("^" + str(v[0]) if v[0] > 1 else "") 
    for v in d])

print("Исходный многочлен 1:", poly1)
print("Исходный многочлен 2:", poly2)
print("Результат сложения многочленов:", s)