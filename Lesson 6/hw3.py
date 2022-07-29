
table = [
    [' ',' ',' '],
    [' ',' ',' '],
    [' ',' ',' ']
]


def print_table():
    print("\n-------------\n".join(["| " + " ".join([v + " |" for v in t]) for t in table]))
    return

print_table()


def player_turn(title):
    x = 0
    y = 0
    str = ""
    while True:
        while len(str) != 2 or str[0] not in ["1","2","3"] or str[1] not in ["1","2","3"]:
            str = input(f"{title}: Введите две цифры xy от 1 до 3 (11 - левый угол, 22 - центр, 33 - правый угол):")
        
        x = int(str[1]) - 1
        y = int(str[0]) - 1
        if table[x][y] != ' ':
            str = ""
            print("Место занято!")
            print_table()
        else:
            return (x,y)

players = [["Игрок 1", player_turn, 'x'], ["Игрок 2", player_turn, '0']]

win_player = ""
turn = 0
while len(win_player) == 0 and turn < 9:
    for player in players:
        sign = player[2]
        x,y = player[1](player[0])
        table[x][y] = sign
        print_table()
        turn += 1
        for i in range(3):
            cols = True
            rows = True   
            right = True
            left = True
            for j in range(3):
                right &= (table[j][j] == sign)
                left &= (table[2-j][j] == sign)
                cols &= (table[i][j] == sign)
                rows &= (table[j][i] == sign)
            
            if left or right or cols or rows:
                win_player = player[0]
        if turn == 9 or len(win_player):
            break

print("Ничья!" if len(win_player) == 0 else win_player + " выиграл!")

                    
