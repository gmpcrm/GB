from model import get_TOKEN, get_columns, get_all_columns, get_teachers, get_students, search_all, search_info
import prettytable as pt
from telegram import *
from telegram.ext import *


print(__bot_api_version__)
print(__version__)

#py_sys42_bot
async def help(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    await update.message.reply_text(
"<pre>Доступные команды\n\n\
/help             этот текст\n\
/students         список 10 учеников\n\
/teachers         список 10 учителей\n\
/search строка    поиск первых 10 результатов по строке\n\
/info код         показывает карточку пользователя по коду Id</pre>", parse_mode='HTML')

def pre(text):
    return '<pre>'+str(text)+'</pre>'

async def teachers(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    result = pt.PrettyTable(get_columns())
    result.add_rows(get_teachers())
    await update.message.reply_text(pre(result), parse_mode='HTML')

async def students(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    result = pt.PrettyTable(get_columns())
    result.add_rows(get_students())
    await update.message.reply_text(pre(result), parse_mode='HTML')

async def info(update, context: ContextTypes.DEFAULT_TYPE) -> None:
    text = ''
    if len(context.args) == 1:
        result = pt.PrettyTable(['Column', 'Data'])
        result.align['Column'] = 'l'
        try:
            data = list(search_info(int(context.args[0]))[0])
            columns = get_all_columns()
            for idx in range(len(columns)):
                result.add_row([columns[idx], data[idx]])
        except:
            text = ''

        text = result.get_string()        
    else: 
        text = 'Пример использования\n\n/info код_пользователя - карточка пользователя по коду Id'

    if update.message:
        await update.message.reply_text(pre(text), parse_mode='HTML')
    else:
        await update.edited_message.reply_text(pre(text), parse_mode='HTML')

async def search(update, context: ContextTypes.DEFAULT_TYPE) -> None:
    text = ''
    if len(context.args) == 1:
        result = pt.PrettyTable(get_columns())
        result.add_rows(search_all(context.args[0]))
        text = result.get_string()
    else: 
        text = 'Пример использования\n\n/search строка_поиска'

    if update.message:
        await update.message.reply_text(pre(text), parse_mode='HTML')
    else:
        await update.edited_message.reply_text(pre(text), parse_mode='HTML')


app = ApplicationBuilder().token(get_TOKEN()).build()
app.add_handler(CommandHandler("help", help))
app.add_handler(CommandHandler("students", students))
app.add_handler(CommandHandler("teachers", teachers))
app.add_handler(CommandHandler("search", search))
app.add_handler(CommandHandler("info", info))

app.run_polling()