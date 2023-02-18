from Core.Models.Contact import Contact
from Core.MVP.PlainTextModel import PlainTextModel
from Core.MVP.CSVModel import CSVModel

class Presenter:
    def __init__(self, view, path_db):
        self.view = view
        self.model = PlainTextModel(path_db)

    def update_current_view(self):
        contact = self.model.current_contact()
        self.view.setDate(contact.date)
        self.view.setFirstName(contact.first_name)
        self.view.setLastName(contact.last_name)
        self.view.setPhone(contact.phone)
        self.view.setCompany(contact.company)
        self.view.setEmail(contact.email)
        self.view.setDescription(contact.description)

    def load_from_file(self):
        self.model.load()
        if self.model.current_book().count() > 0:
            self.model.set_current_index(0)
            self.update_current_view()

    def get_contact_from_view(self):
        return Contact(
            self.view.getDate(),
            self.view.getFirstName(),
            self.view.getLastName(),
            self.view.getPhone(),
            self.view.getCompany(),
            self.view.getEmail(),
            self.view.getDescription()
        )

    def add(self):
        self.model.current_book().add(self.get_contact_from_view())

    def remove(self):
        self.model.current_book().remove(self.get_contact_from_view())

        if self.model.current_book().count() < 1:
            self.model.set_current_index(-1)

            self.view.setFirstName("")
            self.view.setLastName("")
            self.view.setDescription("")
        else:
            self.model.set_current_index(self.model.get_current_index() - 1)
            if self.model.get_current_index() < 0:
                self.model.set_current_index(0)
            self.update_current_view()

    def save_to_file(self):
        self.model.save()

    def join(self, model):
        self.model.current_book().join(model.current_book())

    def next(self):
        if self.model.current_book().count() > 0:
            if self.model.get_current_index() + 1 < self.model.current_book().count():
                self.model.set_current_index(self.model.get_current_index() + 1)
                self.update_current_view()

    def prev(self):
        if self.model.current_book().count() > 0:
            if self.model.get_current_index() - 1 > -1:
                self.model.set_current_index(self.model.get_current_index() - 1)
                self.update_current_view()

    def create_model(self, type, path):
        model = None
        if type == "csv":
            model = CSVModel(path)
        elif type == "txt":
            model = PlainTextModel(path)
        else:
            raise ValueError("Unknown model type")
        return model

    def import_data(self):
        info = self.view.getImportInfo()
        if info is not None:
            model = self.create_model(info[0], info[1])
            model.load()
            self.join(model)

    def export_data(self):
        info = self.view.getExportInfo()
        if info is not None:
            model = self.create_model(info[0], info[1])
            model.join(self.model)
            model.save()

    def search(self):
        info = self.view.getSearchInfo()
        if info is not None:
            result = self.model.search(info)
            if len(result) > 0:
                self.model.set_current_index(result[0])
                self.update_current_view()
