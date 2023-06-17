class Counter:
    def __init__(self):
        self._counter = 0
        self._closed = False

    def __enter__(self):
        if self._closed:
            raise Exception("Нельзя повторно войти в закрытый счетчик.")
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        self._closed = True

    def add(self):
        if self._closed:
            raise Exception("Нельзя добавлять к закрытому счетчику.")
        self._counter += 1

    @property
    def value(self):
        if not self._closed:
            raise Exception("Нельзя получить значение из открытого счетчика.")
        return self._counter
