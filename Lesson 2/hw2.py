print("x y z result")

#оптимизация
result = [" ".join(map(lambda x: str(int(not not x)), v)) 
for v in [(x&4, x&2, x&1, not (x&1 or x&2 or x&4) == (not x&1 and not x&2 and not x&4)) 
for x in range(0,8)]]
print("\n".join(result))