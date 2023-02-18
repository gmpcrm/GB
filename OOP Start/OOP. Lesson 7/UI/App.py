import os

from Config import Config
from Core.MVP.Presenter import Presenter
from UI.ConsoleView import ConsoleView

class App:
    def clear_console(self):
        os.system('cls' if os.name == 'nt' else 'clear')

    def run(self):
        self.clear_console()
        view = ConsoleView()
        presenter = Presenter(view, Config.path_db)
        presenter.load_from_file()

        while True:
            print("0 add, 1 prev, 2 next, 3 save, 4 load, 5 remove, 6 export, 7 import, 8 search, 9 exit")
            key = input().strip()
            self.clear_console()
            if key == "0":
                presenter.add()
            elif key == "1":
                presenter.prev()
            elif key == "2":
                presenter.next()
            elif key == "3":
                presenter.save_to_file()
            elif key == "4":
                presenter.load_from_file()
            elif key == "5":
                presenter.remove()
            elif key == "6":
                presenter.export_data()
            elif key == "7":
                presenter.import_data()
            elif key == "8":
                presenter.search()
            elif key == "9":
                return
            else:
                print("No such command")
