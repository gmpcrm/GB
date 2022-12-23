import os
import pandas as pd
from options import database
import export as ab_export

def load_data(filename):
    return pd.read_csv(filename, sep=";")

def load():
    path = os.getcwd()
    fname =  os.path.join(path, '', database)
    if os.path.isfile(fname):
        return load_data(fname)
    
    fname =  os.path.join(path, 'files', database)
    if os.path.isfile(fname):
        return load_data(fname)

    raise FileNotFoundError()

def import_data(data):
    db = load()
    max_id = db['id'].max() + 1
    data['id'] = range(max_id, max_id+len(data))
    result = pd.concat([db, data])
    ab_export.save(result)
    return data

def import_file(filename):
    return import_data(load_data(filename))
