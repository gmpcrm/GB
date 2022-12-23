from functools import partial
from model import ERROR_MSG
from logger import write_log

def create_controller(model, view):
    def build_expression(expression):
        if view["get_display_text"]() == ERROR_MSG:
            view["clear_display_text"]()
        write_log("PRESSED", expression)
        view["set_display_text"](view["get_display_text"]() + expression)

    for symbol, button in view["buttons"].items():
        if symbol not in {"=", "C"}:
            button.clicked.connect(
                partial(build_expression, symbol)
            )

    def clear_result():
        write_log("CLEAR")
        view["clear_display_text"]()

    def calculate_result():
        expression = view["get_display_text"]()
        write_log("CALCULATE", expression)
        result = model(expression)
        write_log("RESULT", result)
        view["set_display_text"](result)

    view["buttons"]["="].clicked.connect(calculate_result)
    view["display"].returnPressed.connect(calculate_result)
    view["buttons"]["C"].clicked.connect(clear_result)


