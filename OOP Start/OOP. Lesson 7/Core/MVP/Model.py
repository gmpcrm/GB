from Core.Infrastructure.Phonebook import Phonebook
from Core.Models.Contact import Contact

class Model:
    currentBook: Phonebook
    currentIndex: int

    def __init__(self):
        self.currentBook = Phonebook()
        self.currentIndex = 0

    def current_contact(self) -> Contact:
        return self.currentBook.get_contact(self.currentIndex) if self.currentIndex >= 0 else None

    def current_book(self) -> Phonebook:
        return self.currentBook

    def get_current_index(self) -> int:
        return self.currentIndex

    def set_current_index(self, value: int) -> None:
        self.currentIndex = value

    def join(self, model) -> None:
        self.currentBook.join(model.currentBook)

    def search(self, searchInfo):
        contacts = self.currentBook.search(searchInfo)
        indexes = []
        for contact in contacts:
            indexes.append(self.currentBook.get_contact_index(contact))
        return indexes

    def load(self) -> None:
        pass

    def save(self) -> None:
        pass
