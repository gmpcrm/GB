from ast import Delete
from json import load
from turtle import width

from pandas import DataFrame, Series, StringDtype
import Import as ab_import
import export as ab_export
from tkinter import ttk
from tkinter import filedialog
import tkinter as tk
import pandas as pd

from options import database

def list_data():
    data = ab_import.load()
    print(data.to_string())
    return

def fill_data(tree, df):
    tree.delete(*tree.get_children())
    for col in df.columns:
        tree.column(col, anchor='w')
        tree.heading(col, text=col, anchor='w')

    for label, data in df.iterrows():
        tree.insert('', len(tree.get_children()), text=label, values=list(data))

    return

def run():

    ws = tk.Tk()
    ws.title('Список пользователей')

    def do_command(command, inputValue = ''):
        if (command == 'search'):
            df = ab_import.load().applymap(str)
            if len(inputValue):
                result = Series([],dtype=StringDtype())
                for column in df.columns:
                    result = result | df[column].str.contains(inputValue, na=False, case=False)
                df = df[result]
            fill_data(tree, df)
        return

    def do_import():
        fname = filedialog.askopenfilename(title='Выберите имя файла для импорта',  filetypes=[("Comma-Separated Values (*.csv)", "*.csv")])
        if len(fname):            
            fill_data(tree, ab_import.import_file(fname))

        return

    def do_export():
        fname = filedialog.asksaveasfilename(parent = ws, defaultextension = ".txt", filetypes = ab_export.supported_types)
        if len(fname):
            ab_export.export_file(fname, '')
        return

    def do_add():
        def destroy_dlg(dlg):
            dlg.destroy()

        def fetch(entries, dlg):
            for entry in entries:
                columns = []
                data = [[]]
                df = ab_import.load()
                for column in df.columns:
                    columns.append(column)
                    if column == "id":
                        data[0].append(-1)
                    else:
                        data[0].append(entry[1].get())

                newdf = pd.DataFrame(data, columns=columns)
                ab_import.import_data(newdf)
                fill_data(tree, ab_import.load())
            destroy_dlg(dlg) 

        def makeform(root, df):
            entries = []
            for column in df.columns:
                if column != "id":
                    row = tk.Frame(root)
                    lab = tk.Label(row, width=15, text=column, anchor='w')
                    ent = tk.Entry(row)
                    row.pack(side=tk.TOP, fill=tk.X, padx=5, pady=5)
                    lab.pack(side=tk.LEFT)
                    ent.pack(side=tk.RIGHT, expand=tk.YES, fill=tk.X)
                    entries.append((column, ent))
            return entries

        dlg = tk.Toplevel(ws)
        dlg.title('Добавить нового пользователя')
        dlg.transient(ws)
        dlg.grab_set()
        df = ab_import.load()
        ents = makeform(dlg, df)
        dlg.bind('<Return>', (lambda event, e=ents: fetch(e, dlg)))   
        dlg.bind('<Escape>', (lambda event: destroy_dlg(dlg)))
        b1 = tk.Button(dlg, text='      OK      ', command=(lambda e=ents: fetch(e, dlg)))
        b1.pack(side=tk.LEFT, padx=5, pady=5)
        b2 = tk.Button(dlg, text='Отмена', command=(lambda: destroy_dlg(dlg)))
        b2.pack(side=tk.LEFT, padx=5, pady=5)
        dlg.focus()

        dlg.resizable(False, False)  # This code helps to disable windows from resizing

        dlg_height = 250
        dlg_width = 450

        screen_width = ws.winfo_screenwidth()
        screen_height = ws.winfo_screenheight()

        dlg_x = int((screen_width/2) - (dlg_width/2))
        dlg_y = int((screen_height/2) - (dlg_height/2))

        dlg.geometry("{}x{}+{}+{}".format(dlg_width, dlg_height, dlg_x, dlg_y))

        ws.wait_window(dlg)

    def do_delete():
        # TODO
        return

    topFrame = tk.Frame(ws)
    topFrame.pack(side='top', ipadx=5, ipady=5, fill='x')
    textSearch=tk.Text(topFrame, height=1, width=100)
    textSearch.pack(side ='left', fill='x', expand='yes', padx=10)
    buttonSearch=tk.Button(topFrame, height=1, width=10, text="Поиск", command=lambda: do_command('search', textSearch.get("1.0","end-1c")))
    buttonSearch.pack(side ='left', padx=5)
    buttonAdd=tk.Button(topFrame, height=1, width=10, text="Добавить", command=lambda: do_add())
    buttonAdd.pack(side ='left', padx=5)
    buttonRemove=tk.Button(topFrame, height=1, width=10, text="Удалить", state = 'disabled', command=lambda: do_delete())
    buttonRemove.pack(side ='left', padx=5)
    buttonImport=tk.Button(topFrame, height=1, width=10, text="Импорт", command=lambda: do_import())
    buttonImport.pack(side ='left', padx=5)
    buttonExport=tk.Button(topFrame, height=1, width=10, text="Экспорт", command=lambda: do_export())
    buttonExport.pack(side ='left', padx=5)

    df = ab_import.load()
    tree = ttk.Treeview(ws, columns=list(df.columns), show='headings', selectmode ='browse')
    tree.config(height=100)
    tree.pack(side ='left', fill='both', expand='yes')
    vsb = ttk.Scrollbar(ws, orient ='vertical', command=tree.yview) 
    vsb.pack(side='right', fill='y')
    tree.configure(xscrollcommand=vsb.set)
  
    fill_data(tree, df)
    
    style = ttk.Style()
    style.theme_use("default")
    style.map("Treeview")

    ws.mainloop()

    return
