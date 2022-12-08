from telegram import Update
from telegram.ext import ApplicationBuilder, CommandHandler, ContextTypes
from bot_commands import *


app = ApplicationBuilder().token("5632531433:AAEUSQ2PJCFIpu_-dPOHHAaF-d852F7Qpy0").build()

app.add_handler(CommandHandler("hello", hello))
app.add_handler(CommandHandler("reset", reset))
app.add_handler(CommandHandler("help", help))
app.add_handler(CommandHandler("show", show))
app.add_handler(CommandHandler("turn", bot_turn))
app.add_handler(CommandHandler("playerX", playerX))
app.add_handler(CommandHandler("player0", player0))


app.add_handler(CommandHandler("11", cr11))
app.add_handler(CommandHandler("21", cr21))
app.add_handler(CommandHandler("31", cr31))
app.add_handler(CommandHandler("12", cr12))
app.add_handler(CommandHandler("22", cr22))
app.add_handler(CommandHandler("32", cr32))
app.add_handler(CommandHandler("13", cr13))
app.add_handler(CommandHandler("23", cr23))
app.add_handler(CommandHandler("33", cr33))

reset_table()
app.run_polling()