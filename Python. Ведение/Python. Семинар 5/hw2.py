import re
#data = "aaaaabcccccddddeeeefffffffffffffffffggggghhhhhhhhhhhhiiiiijjjjkkkkkklllllllllllllmmmmmnnoop"

file_encode = "files\\rle_encode.txt"
file_decode = "files\\rle_decode.txt"

def rle_encode(data):
    count = 0
    result = ''
    prev = ''
    for c in data:
        if c != prev:
            if prev != '':
                result += str(count) + prev
            count = 1
            prev = c
        else:
            count += 1
    
    result += str(count) + prev
    return result

def rle_decode(data):
    result = ''
    s1 = re.findall(r"\d+|\w", data)
    for idx in range(0, len(s1), 2):
        result += s1[idx+1] * int(s1[idx]) 
    return result

with open(file_encode, 'r') as f:
    data = f.readline()
    print("Original unencoded data:", data)
    print("Encoded data:", rle_encode(data))

with open(file_decode, 'r') as f:
    data = f.readline()
    print("Original encoded data:", data)
    print("Decoded data:", rle_decode(data))
