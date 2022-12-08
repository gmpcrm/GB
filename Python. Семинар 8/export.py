import os
import pandas as pd
import Import as ab_import
from os.path import splitext
from options import database

#для импорта-экспорта нужен pandas: pip install pandas

#создает новые файлы
#ab_export.export_file("fio_export.csv", "csv")
#ab_export.export_file("fio_export.html", "html")
#ab_export.export_file("fio_export.json", "json")
#ab_export.export_file("fio_export.txt", "text")

#для Excel нужен модуль openpyxl: pip install openpyxl
#import openpyxl
#ab_export.export_file("fio_export.xlsx", "excel")

supported_export = ["csv", "excel", "html", "json", "text"]
supported_types = [("Comma-Separated Values (*.csv)", ".csv"), ("Microsoft Excel File (*.xls)",".xls"), ("HyperText Markup Language (*.html)",".html"), ("JavaScript Object Notation (*.json)",".json"), ("Text File (*.txt)",".txt")]

# сохранение строки в файл
def write_file(target, str):
    with open(target, "w", encoding="utf-8") as f:
        return f.write(str)

def save(data):
    path = os.getcwd()
    fname =  os.path.join(path, '', database)
    if os.path.isfile(fname):
        return save_data(fname, "csv", data)
    
    fname =  os.path.join(path, 'files', database)
    if os.path.isfile(fname):
        return save_data(fname, "csv", data)

    raise FileNotFoundError()

# запись данных DataFrame в файл
# mode: csv, excel, html, json, text
# нет обработки ошибок
def save_data(target, mode, data: pd.DataFrame):
    ext = splitext(target)[1]
    if mode == "csv" or ext == '.csv':
        return data.to_csv(target, index=False, sep=";")
    if mode == "excel" or ext == '.xls':
        return data.to_excel(target, index=False)
    if mode == "html" or ext == '.html':
        return write_file(target, data.to_html(index=False))
    if mode == "json" or ext == '.json':
        return write_file(target, data.to_json())
    if mode == "text" or ext == '.txt':
        return write_file(target, data.to_string(index=False))

# экспорт текущей базы в файл
# зачитываем текущую базу
# экспортируем в другой формат
# mode: csv, excel, html, json, text
def export_file(target, mode):
    df = ab_import.load_data(database)
    return save_data(target, mode, df)

def export_data():
    mode = ""
    while mode not in supported_export:
        mode = input("Введите режим экспорта (" + ", ".join(supported_export) + "):")

    filename = input("Введите имя файла для экспорта:")
    export_file(filename, mode)
    print(f"Данные были экспортирваны в {filename}")
    return
