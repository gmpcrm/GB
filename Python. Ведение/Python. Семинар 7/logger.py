from datetime import datetime

filename = "files\\calclog.txt"

def write_log(mode, s = ""):
    with open(filename, 'a') as f:
        now = datetime.now()
        f.write(f'{now.strftime("%Y-%m-%d %H:%M:%S")}\t{mode}\t{s}\n')
