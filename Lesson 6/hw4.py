data = "aaaaabcccccddddeeeefffffffffffffffffggggghhhhhhhhhhhhiiiiijjjjkkkkkklllllllllllllmmmmmnnoop"

count = 0
result = ""
prev = ""
for c in data:
    if c != prev:
        if prev != "":
            result += str(count) + prev
        count = 1
        prev = c
    else:
        count += 1

result += str(count) + prev
print(result)