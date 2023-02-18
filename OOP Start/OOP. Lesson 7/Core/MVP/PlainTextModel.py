import datetime

from Config import Config
from Core.MVP.Model import Model
from Core.Models.Contact import Contact

class PlainTextModel(Model):
    def __init__(self, path):
        super().__init__()
        self.path = path

    def load(self):
        try:
            with open(self.path, mode='r') as file:
                currentBook = self.currentBook
                fdate = file.readline().strip()
                while fdate:
                    firstName = file.readline().strip()
                    lastName = file.readline().strip()
                    phone = file.readline().strip()
                    company = file.readline().strip()
                    email = file.readline().strip()
                    description = file.readline().strip()
                    currentBook.add(Contact(datetime.datetime.strptime(fdate, Config.date_format).date(), firstName, lastName, phone, company, email, description))
                    fdate = file.readline().strip()

        except IOError as ex:
            print(ex)

    def save(self):
        try:
            with open(self.path, mode='w') as file:
                currentBook = self.currentBook
                for i in range(currentBook.count()):
                    contact = currentBook.get_contact(i)
                    fdate = contact.get_date().strftime(Config.date_format)
                    firstName = contact.get_first_name()
                    lastName = contact.get_last_name()
                    phone = contact.get_phone()
                    company = contact.get_company()
                    email = contact.get_email()
                    description = contact.get_description()
                    file.write(f'{fdate}\n{firstName}\n{lastName}\n{phone}\n{company}\n{email}\n{description}\n')

        except IOError as ex:
            print(ex)
