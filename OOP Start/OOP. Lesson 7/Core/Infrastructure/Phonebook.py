from ..Models.Contact import Contact

class Phonebook:
    def __init__(self):
        self.contacts = []

    # create
    def add(self, contact: Contact) -> bool:
        if contact not in self.contacts:
            self.contacts.append(contact)
            return True
        return False

    # join current contacts with other phonebook contacts
    def join(self, phonebook: 'Phonebook') -> bool:
        if phonebook is not None:
            return self.add_all(phonebook.get_contacts())
        return False

    # join current contacts with other phonebook contacts
    def add_all(self, contacts) -> bool:
        if contacts is not None:
            for contact in contacts:
                self.contacts.append(contact)
            return True
        return False

    # read
    def get_contact(self, index: int) -> Contact:
        return self.contacts[index] if self.contains(index) else None

    def get_contact_index(self, contact: Contact) -> int:
        return self.contacts.index(contact) if contact in self.contacts else -1

    # delete
    def remove(self, contact: Contact) -> bool:
        if self.get_contact_index(contact) != -1:
            self.contacts.remove(contact)
            return True
        return False

    def contains(self, index: int) -> bool:
        return self.contacts is not None and len(self.contacts) > index

    def get_contacts(self):
        return self.contacts

    def search(self, query):
        result = []
        if query is not None and len(query) > 0:
            for contact in self.contacts:
                if query[0].lower() in str(contact).lower():
                    result.append(contact)
        return result

    def count(self) -> int:
        return len(self.contacts)
