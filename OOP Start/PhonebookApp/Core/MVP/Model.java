package PhonebookApp.Core.MVP;

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

    public abstract void load();
    public abstract void save();
}