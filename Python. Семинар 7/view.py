from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import (
    QGridLayout,
    QLineEdit,
    QMainWindow,
    QPushButton,
    QVBoxLayout,
    QWidget,
)

WINDOW_SIZE = 235
DISPLAY_HEIGHT = 35
BUTTON_SIZE = 40

def create_view():
    window = QMainWindow()
    window.setWindowTitle("Calculator")
    window.setFixedSize(WINDOW_SIZE, WINDOW_SIZE)
    
    generalLayout = QVBoxLayout()
    centralWidget = QWidget(window)
    centralWidget.setLayout(generalLayout)
    window.setCentralWidget(centralWidget)

    display = QLineEdit()
    display.setFixedHeight(DISPLAY_HEIGHT)
    display.setAlignment(Qt.AlignmentFlag.AlignRight)
    display.setReadOnly(True)
    generalLayout.addWidget(display)

    buttons = {}
    layout = QGridLayout()
    keyboard = [
        ["7", "8", "9", "/", "C"],
        ["4", "5", "6", "*", "("],
        ["1", "2", "3", "-", ")"],
        ["0", ".", "^", "+", "="],
    ]

    for row, keys in enumerate(keyboard):
        for col, key in enumerate(keys):
            buttons[key] = QPushButton(key)
            buttons[key].setFixedSize(BUTTON_SIZE, BUTTON_SIZE)
            layout.addWidget(buttons[key], row, col)

    generalLayout.addLayout(layout)

    def set_display_text(text):
        display.setText(text)
        display.setFocus()

    def get_display_text():
        return display.text()

    def clear_display_text():
        set_display_text("")

    return {
        "window": window,
        "display": display,
        "buttons": buttons,
        "set_display_text": set_display_text,
        "get_display_text": get_display_text,
        "clear_display_text": clear_display_text
    }

