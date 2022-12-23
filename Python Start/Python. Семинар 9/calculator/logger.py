from datetime import datetime

filename = "files\\py_calc42.log"

def write_log(mode, s = ""):
    with open(filename, 'a') as f:
        now = datetime.now()
        f.write(f'{now.strftime("%Y-%m-%d %H:%M:%S")} {mode} {s}\n')

def reset_log():
    open(filename, 'w').close()

def read_log():
       with open(filename, 'r') as f:
        return ''.join(f.readlines())