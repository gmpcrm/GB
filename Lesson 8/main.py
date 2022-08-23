from telegram import Update
from telegram.ext import ApplicationBuilder, CommandHandler, ContextTypes
from bot_commands import *


app = ApplicationBuilder().token("5632531433:AAEUSQ2PJCFIpu_-dPOHHAaF-d852F7Qpy0").build()

app.add_handler(CommandHandler("hello", hello))

app.run_polling()