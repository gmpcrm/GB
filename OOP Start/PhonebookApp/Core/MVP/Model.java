package PhonebookApp.Core.MVP;

import java.util.ArrayList;
import java.util.List;

import PhonebookApp.Core.Infrastructure.Phonebook;
import PhonebookApp.Core.Models.Contact;

public abstract class Model {
    private Phonebook currentBook;
    private int currentIndex;

    public Model() {
        currentBook = new Phonebook();
        currentIndex = 0;
    }

    public Contact currentContact() {
        if (currentIndex >= 0) {
            return currentBook.getContact(currentIndex);
        } else {
            return null;
        }
    }

    public Phonebook currentBook() {
        return this.currentBook;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }

    public void join(Model model) {
        currentBook.join(model.currentBook());
    }

    public List<Integer> search(String[] searchInfo) {
        List<Contact> contacts = currentBook.search(searchInfo);
        List<Integer> indexes = new ArrayList<Integer>();
        for (Contact contact : contacts) {
            indexes.add(currentBook.getContactIndex(contact));
        }

        return indexes;
    }

    public abstract void load();
    public abstract void save();
}