s1 = ["hello", "2", "world", ":-)"]
s2 = ["1234", "1567", "-2", "computer science"]
s3 = ["Russia", "Denmark", "Kazan"]

def str3(s):
    r = []
    for value in s:
        if len(value) <= 3:
            r.append(value)

    return r

print(str3(s1))
print(str3(s2))
print(str3(s3))