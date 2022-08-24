from telegram import Update
from telegram.ext import ApplicationBuilder, CommandHandler, ContextTypes

table = []
player_mode = 'x'
bot_mode = '0'
turn_count = 0


def reset_table():
    global table
    table = [
        [' ',' ',' '],
        [' ',' ',' '],
        [' ',' ',' ']
    ]
    return
    
def get_table():
    global table
    return "\n-------------\n".join(["| " + " ".join([v + " |" for v in t]) for t in table])

async def reset(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    global turn_count
    turn_count = 0
    reset_table()
    return

async def hello(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await update.message.reply_text(f'Hello {update.effective_user.first_name}')

async def help(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await update.message.reply_text(
"Доступные команды:\n\n\
reset - начать заново\n\
show - показать текущее состояние\n\n\
playerX - игрок играет за X, бот за 0\n\
player0 - игрок играет за 0, бот за X\n\n\
turn - ходит бот\n\n\
11 - игрок ходит на колонка 1 строка 1\n\
21 - игрок ходит на колонка 2 строка 1\n\
12 - игрок ходит на колонка 1 строка 2\n\
22 - игрок ходит на колонка 2 строка 2\n\
32 - игрок ходит на колонка 3 строка 2\n\
13 - игрок ходит на колонка 1 строка 3\n\
23 - игрок ходит на колонка 2 строка 3\n\
33 - игрок ходит на колонка 3 строка 3\n")


async def playerX(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    global player_mode
    global bot_mode
    player_mode = 'x'
    bot_mode = '0'
    return

async def player0(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    global player_mode
    global bot_mode
    player_mode = '0'
    bot_mode = 'x'
    return

async def show(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await update.message.reply_text(get_table())

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


async def do_turn(update: Update, context: ContextTypes.DEFAULT_TYPE, mode, col, row):
    global turn_count
    global player_mode
    global bot_mode
    global table
    x = col - 1
    y = row - 1
    if table[y][x] != ' ':
        await update.message.reply_text("Место занято!\n")
        return await show(update, context)        
    else:
        turn_count += 1
        table[y][x] = mode

    win = win_condition(mode)
    if len(win):
        await show(update, context)

    if win == ' ':
        await update.message.reply_text("Ничья\n")
    elif win == player_mode:
        await update.message.reply_text("Игрок выиграл!\n")
    elif win == bot_mode:
        await update.message.reply_text("Бот выиграл!\n")

    if len(win):
        await reset(update, context)
    elif mode == player_mode:
        return await bot_turn(update, context)

    await show(update, context)

async def bot_turn(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    global table
    for x in range(0,3):
        for y in range(0,3):
            if table[y][x] == ' ':
                return await do_turn(update, context, bot_mode, x + 1, y + 1)
                
    return    

async def cr11(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await do_turn(update, context, player_mode, 1, 1)

async def cr21(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await do_turn(update, context, player_mode, 2, 1)

async def cr31(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await do_turn(update, context, player_mode, 3, 1)

async def cr12(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await do_turn(update, context, player_mode, 1, 2)

async def cr22(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await do_turn(update, context, player_mode, 2, 2)

async def cr32(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await do_turn(update, context, player_mode, 3, 2)

async def cr13(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await do_turn(update, context, player_mode, 1, 3)

async def cr23(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await do_turn(update, context, player_mode, 2, 3)

async def cr33(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await do_turn(update, context, player_mode, 3, 3)


