from datetime import datetime

class Config:
    date_format = "%d.%m.%Y"
    path_db = "data.db"

    @staticmethod
    def of_pattern():
        return datetime.strptime(Config.date_format, Config.date_format)
