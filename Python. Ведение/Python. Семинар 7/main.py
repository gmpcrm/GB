import sys
from PyQt6.QtWidgets import QApplication
from view import create_view
from model import create_model
from controller import create_controller
from logger import write_log

def main():
    write_log("START")
    app = QApplication([])
    view = create_view()
    model = create_model()

    view["window"].show()
    create_controller(model, view)

    code = app.exec()
    write_log("EXIT")
    sys.exit(code)

if __name__ == "__main__":
    main()
