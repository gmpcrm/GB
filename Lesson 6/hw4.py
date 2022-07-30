import os
#data = "aaaaabcccccddddeeeefffffffffffffffffggggghhhhhhhhhhhhiiiiijjjjkkkkkklllllllllllllmmmmmnnoop"

path = "c:\\Users\\jonson\\Dropbox\\Projects\\GB\\Lesson 6" 
file = "rledata.txt"
filename = os.path.join(path, file)

result = ""
with open(filename, 'r') as f:
    data = f.read()
    count = 0
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