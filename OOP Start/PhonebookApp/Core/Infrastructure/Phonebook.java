package PhonebookApp.Core.Infrastructure;

import java.util.ArrayList;
import java.util.List;

import PhonebookApp.Core.Models.Contact;

public class Phonebook {
    private List<Contact> contacts;
    
    public Phonebook() {
        contacts = new ArrayList<Contact>();
    }

    // create
    public boolean add(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            return true;
        }

        return false;
    }

    // join current contacts with other phonebook contacts
    public boolean join(Phonebook phonebook) {
        if (phonebook != null) {
            return addAll(phonebook.getContacts());
        }

        return false;
    }

    // join current contacts with other phonebook contacts
    public boolean addAll(List<Contact> contacts) {
        if (contacts != null) {
            for (Contact contact : contacts) {
                this.contacts.add(contact);
            }

            return true;
        }

        return false;
    }

    // read
    public Contact getContact(int index) {
        return contains(index) ? contacts.get(index) : null;
    }

    // update
    // ???...

    // delete
    public boolean remove(Contact contact) {
        if (contacts.indexOf(contact) != -1) {
            contacts.remove(contact);
            return true;
        }

        return false;
    }


    private boolean contains(int index) {
        return contacts != null && contacts.size() > index;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public int count() {
        return contacts.size();
    }
}
