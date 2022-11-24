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
    row = 0
    col = 0
    while True:
        srow = ''
        while len(srow) != 1 and srow not in ["1","2","3"]:
            srow = input(f"{title}: Введите номер строки (от 1 до 3):")

        scol = ''
        while len(scol) != 1 and scol not in ["1","2","3"]:
            scol = input(f"{title}: Введите номер колонки (от 1 до 3):")

        row = int(srow) - 1
        col = int(scol) - 1

        if table[row][col] != ' ':
            print("Место занято!")
            print_table()
        else:
            return (row,col)

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
