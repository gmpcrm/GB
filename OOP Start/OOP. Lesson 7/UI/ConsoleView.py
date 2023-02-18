import datetime

from Core.MVP.View import View

class ConsoleView(View):
    def __init__(self):
        self.inp = input

    def getDate(self):
        dateFormat = "%Y-%m-%d"
        date_str = self.inp("Date in format [{}]: ".format(dateFormat))
        return datetime.datetime.strptime(date_str, dateFormat).date()

    def setDate(self, value):
        print("Date: {}".format(value.strftime("%Y-%m-%d")))

    def getFirstName(self):
        return self.inp("FirstName: ")

    def setFirstName(self, value):
        print("FirstName: {}".format(value))

    def getLastName(self):
        return self.inp("LastName: ")

    def setLastName(self, value):
        print("LastName: {}".format(value))

    def getPhone(self):
        return self.inp("Phone: ")

    def setPhone(self, value):
        print("Phone: {}".format(value))

    def getCompany(self):
        return self.inp("Company: ")

    def setCompany(self, value):
        print("Company: {}".format(value))

    def getEmail(self):
        return self.inp("Email: ")

    def setEmail(self, value):
        print("Email: {}".format(value))

    def getDescription(self):
        return self.inp("Description: ")

    def setDescription(self, value):
        print("Description: {}".format(value))
        print()

    def getImportInfo(self):
        print("0 return, 1 Import from CSV, 2 Import from TXT")
        key = self.inp()
        while True:
            if key == "0":
                return None
            elif key == "1":
                return ["csv", self.inp()]
            elif key == "2":
                return ["txt", self.inp()]
            else:
                print("No such command")
                key = self.inp()

    def getExportInfo(self):
        print("0 return, 1 Export to CSV, 2 Export to TXT")
        key = self.inp()
        while True:
            if key == "0":
                return None
            elif key == "1":
                return ["csv", self.inp()]
            elif key == "2":
                return ["txt", self.inp()]
            else:
                print("No such command")
                key = self.inp()

    def getSearchInfo(self):
        key = self.inp("Enter query string: ")
        return [key]
