from datetime import date

class Contact:
    def __init__(self, date, first_name, last_name, phone, company, email, description):
        self.date = date
        self.first_name = first_name
        self.last_name = last_name
        self.phone = phone
        self.company = company
        self.email = email
        self.description = description

    def get_date(self):
        return self.date

    def set_date(self, date):
        self.date = date

    def get_first_name(self):
        return self.first_name

    def set_first_name(self, first_name):
        self.first_name = first_name

    def get_last_name(self):
        return self.last_name

    def set_last_name(self, last_name):
        self.last_name = last_name

    def get_phone(self):
        return self.phone

    def set_phone(self, phone):
        self.phone = phone

    def get_company(self):
        return self.company

    def set_company(self, company):
        self.company = company

    def get_email(self):
        return self.email

    def set_email(self, email):
        self.email = email

    def get_description(self):
        return self.description

    def set_description(self, description):
        self.description = description

    def __str__(self):
        return f"Contact{{date={self.date}, first_name='{self.first_name}', last_name='{self.last_name}', phone='{self.phone}', company='{self.company}', email='{self.email}', description='{self.description}'}}"

    def __lt__(self, other):
        if self.first_name == other.first_name:
            if self.last_name == other.last_name:
                if self.phone == other.phone:
                    if self.company == other.company:
                        if self.email == other.email:
                            if self.description == other.description:
                                return self.date < other.date
                            else:
                                return self.description < other.description
                        else:
                            return self.email < other.email
                    else:
                        return self.company < other.company
                else:
                    return self.phone < other.phone
            else:
                return self.last_name < other.last_name
        else:
            return self.first_name < other.first_name

    def __eq__(self, other):
        if isinstance(other, Contact):
            return (self.date == other.date and self.first_name == other.first_name and
                    self.last_name == other.last_name and self.phone == other.phone and
                    self.company == other.company and self.email == other.email and
                    self.description == other.description)
        return False
