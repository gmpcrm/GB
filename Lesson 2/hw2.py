print("x y z result")

for x in 0,1:
    for y in 0,1:
        for z in 0,1:
            result = not (x or y or z) == (not x and not y and not z)
            print(x,y,z,int(result))