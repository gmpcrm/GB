import csv
import datetime

from Config import Config
from Core.MVP.Model import Model
from Core.Models.Contact import Contact


class CSVModel(Model):
    def __init__(self, path):
        super().__init__()
        self.path = path

    def load(self):
        try:
            with open(self.path, newline='') as file:
                reader = csv.reader(file)
                currentBook = self.currentBook
                for row in reader:
                    fdate = datetime.datetime.strptime(row[0], Config.date_format).date()
                    firstName = row[1]
                    lastName = row[2]
                    phone = row[3]
                    company = row[4]
                    email = row[5]
                    description = row[6]
                    currentBook.add(Contact(fdate, firstName, lastName, phone, company, email, description))

        except IOError as ex:
            print(ex)

    def save(self):
        try:
            with open(self.path, mode='w', newline='') as file:
                writer = csv.writer(file)
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
                    writer.writerow([fdate, firstName, lastName, phone, company, email, description])

        except IOError as ex:
            print(ex)
