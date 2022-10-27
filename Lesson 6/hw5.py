import re

path = "c:\\Users\\jonson\\Dropbox\\Projects\\GB\\Lesson 5" 

def readstr(filename):    
    poly = []
    with open(filename, 'r') as f:
        poly = f.readlines()

    if len(poly) > 0:
        return poly[0].replace("\n", "").replace(" ", "").replace("*", "").replace("^", "").replace("=0","")
    else:
        return ""

def dupdate(d, str):
    s1 = re.split(r"\+", str)
    for value in s1:
        s = re.split(r"x", value)
        k = int(s[0])
        sf = s[1] if len(s) > 1 else "0"
        f = int(sf) if len(sf) > 0 else 1
        d[f] = d.get(f, 0) + k

d = {}
dupdate(d, readstr(path + "\\poly1.txt"))
dupdate(d, readstr(path + "\\poly2.txt"))
d = sorted(d.items(), reverse=True)

s = " + ".join(
[str(v[1]) + ("*" + "x" if v[0] > 0 else "") + ("^" + str(v[0]) if v[0] > 1 else "") 
for v in d]) + " = 0"

print(s)