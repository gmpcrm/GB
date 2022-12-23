from telegram import *
from telegram.ext import *

player_mode = 'X'
bot_mode = 'O'
turn_count = 0
status = 'ХОДИТЕ ЗА ' + player_mode

table = [
    [' ',' ',' '],
    [' ',' ',' '],
    [' ',' ',' ']
]

def reset_table():
    global table
    table = [
        [' ',' ',' '],
        [' ',' ',' '],
        [' ',' ',' ']
    ]
    return
    
def get_status():
    return status

def get_table():
    buttons = []
    for row in range(0,3):
        br = []
        for col in range(0,3):
            br.append(InlineKeyboardButton(table[row][col], callback_data=f"{row}{col}"))
        buttons.append(br)
    return InlineKeyboardMarkup(buttons)

def reset():
    global turn_count
    turn_count = 0
    reset_table()
    return

def set_playerX():
    global player_mode
    global bot_mode
    global status
    reset()
    player_mode = 'X'
    bot_mode = 'O'
    status = 'ХОДИТЕ ЗА ' + player_mode
    return

def set_player0():
    global player_mode
    global bot_mode
    global status
    reset() 
    player_mode = 'O'
    bot_mode = 'X'
    status = 'ХОДИТЕ ЗА ' + player_mode
    return

def win_condition(mode):
    global table
    global turn_count
    for i in range(3):
        cols = True
        rows = True   
        right = True
        left = True
        for j in range(3):
            right &= (table[j][j] == mode)
            left &= (table[2-j][j] == mode)
            cols &= (table[i][j] == mode)
            rows &= (table[j][i] == mode)
        
        if left or right or cols or rows:
            return mode

    return ' ' if turn_count == 9 else ''

def do_turn(mode, col, row):
    global turn_count
    global player_mode
    global bot_mode
    global table
    global status
    x = col
    y = row
    if table[y][x] != ' ':
        status = 'ЗАНЯТО'
    else:
        turn_count += 1
        table[y][x] = mode

    win = win_condition(mode)
    if win == ' ':
        status = "НИЧЬЯ"
    elif win == player_mode:
        status = "ИГРОК ВЫИГРАЛ"
    elif win == bot_mode:
        status = "БОТ ВЫИГРАЛ"
    else:
        status = 'ХОДИТЕ ЗА ' + player_mode

    return win

def bot_turn():
    global table
    for x in range(0,3):
        for y in range(0,3):
            if table[y][x] == ' ':
                return do_turn(bot_mode, x, y)                
    return    
