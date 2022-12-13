import model
import logger
from telegram import *
from telegram.ext import *

keyboard = InlineKeyboardMarkup([
                [InlineKeyboardButton('7', callback_data='7'),
                 InlineKeyboardButton('8', callback_data='8'),
                 InlineKeyboardButton('9', callback_data='9'),
                 InlineKeyboardButton('/', callback_data='/'),
                 InlineKeyboardButton('C', callback_data='C')],

                [InlineKeyboardButton('4', callback_data='4'),
                 InlineKeyboardButton('5', callback_data='5'),
                 InlineKeyboardButton('6', callback_data='6'),
                 InlineKeyboardButton('*', callback_data='*'),
                 InlineKeyboardButton('(', callback_data='(')],

                [InlineKeyboardButton('1', callback_data='1'),
                 InlineKeyboardButton('2', callback_data='2'),
                 InlineKeyboardButton('3', callback_data='3'),
                 InlineKeyboardButton('-', callback_data='-'),
                 InlineKeyboardButton(')', callback_data=')')],

                [InlineKeyboardButton('0', callback_data='0'),
                 InlineKeyboardButton('.', callback_data='.'),
                 InlineKeyboardButton('^', callback_data='^'),
                 InlineKeyboardButton('+', callback_data='+'),
                 InlineKeyboardButton('=', callback_data='=')]])

async def help(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await update.message.reply_text('Available commands for py_calc42\n\n/start - start calculator\n/log - show log\n/clear - clear log')

async def clear(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    logger.reset_log()
    await update.message.reply_text(f'Log is empty')

async def log(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    data = logger.read_log()
    await update.message.reply_text(data, parse_mode='HTML')

async def start(update: Update, context: CallbackContext) -> None:    
    await context.bot.send_message(chat_id=update.effective_chat.id, text="0", reply_markup=keyboard)

value = ''
async def button(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    global value
    global keyboard
    query = update.callback_query

    await query.answer()

    if value == model.ERROR_MSG:
        value = ''

    data = query.data
    if data == 'C':
        value = ''
        logger.write_log("CLEAR")
    elif data == '=':
        logger.write_log("CALCULATE", value)
        value = model.evaluate_expression(value)
        logger.write_log("RESULT", value)
    else:
        value += data
        logger.write_log("PRESSED", data)
        
    await context.bot.edit_message_text(chat_id=query.message.chat.id, message_id=query.message.id, text='0' if value == '' else value, reply_markup=keyboard)

app = ApplicationBuilder().token("5845372200:AAF1xHgPhUSmCg6v3C8k1qvk2L0xdG70ymI").build()

app.add_handler(CommandHandler("help", help))
app.add_handler(CommandHandler("start", start))
app.add_handler(CommandHandler("clear", clear))
app.add_handler(CommandHandler("log", log))
app.add_handler(CallbackQueryHandler(button))

app.run_polling()