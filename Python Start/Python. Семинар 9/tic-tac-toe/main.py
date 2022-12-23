from telegram import *
from telegram.ext import *
import model

async def help(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await update.message.reply_text(
"Доступные команды\n\n\
/help - этот текст\n\
/start - начать заново\n\
/playerX - игрок играет за X, бот за O\n\
/player0 - игрок играет за O, бот за X")

async def defstate(update: Update, context: CallbackContext) -> None:
    await context.bot.send_message(chat_id=update.effective_chat.id, text=model.get_status(), reply_markup=model.get_table())

async def start(update: Update, context: CallbackContext) -> None:
    model.reset()
    await defstate(update, context)

async def playerX(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    model.set_playerX()
    await defstate(update, context)

async def player0(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    model.set_player0()
    await defstate(update, context)

async def button(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    global value
    global keyboard
    query = update.callback_query

    await query.answer()

    data = query.data
    row = int(data[0])
    col = int(data[1])

    win = model.do_turn(model.player_mode, col, row)
    if win == '':
        win = model.bot_turn()
        
    await context.bot.edit_message_text(chat_id=query.message.chat.id, message_id=query.message.id, text=model.get_status(), reply_markup=model.get_table())


TOKEN = None
with open("token.txt") as f:
    TOKEN = f.read().strip()

app = ApplicationBuilder().token(TOKEN).build()


app.add_handler(CommandHandler("help", help))
app.add_handler(CommandHandler("start", start))
app.add_handler(CommandHandler("playerX", playerX))
app.add_handler(CommandHandler("player0", player0))

app.add_handler(CallbackQueryHandler(button))

app.run_polling()