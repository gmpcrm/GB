package PhonebookApp.Core.MVP;

import PhonebookApp.Core.Models.Contact;

public class Presenter {    
    private PlainTextModel model;
    private View view;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new PlainTextModel(pathDb);
    }

    private void updateCurrentView() {
        var contact = model.currentContact();
        view.setDate(contact.getDate());
        view.setFirstName(contact.getFirstName());
        view.setLastName(contact.getLastName());
        view.setPhone(contact.getPhone());
        view.setCompany(contact.getCompany());
        view.setEmail(contact.getEmail());
        view.setDescription(contact.getDescription());
    }

    public void loadFromFile() {
        model.load();
        if (model.currentBook().count() > 0) {
            model.setCurrentIndex(0);
            updateCurrentView();
        }
    }

    private Contact getContactFromView() {
        return new Contact(view.getDate(), view.getFirstName(), view.getLastName(), view.getPhone(), view.getCompany(), view.getEmail(), view.getDescription());
    }

    public void add() {
        model.currentBook().add(getContactFromView());
    }

    public void remove() {
        model.currentBook().remove(getContactFromView());

        if (model.currentBook().count() < 1) {
            model.setCurrentIndex(-1);

            view.setFirstName("");
            view.setLastName("");
            view.setDescription("");
        } else {
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            if (model.getCurrentIndex() < 0)
                model.setCurrentIndex(0);
                updateCurrentView();
            }
    }

    public void saveToFile() {
        model.save();
    }

    public void join(Model model){
        this.model.currentBook().join(model.currentBook());
    }

    public void next() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() + 1 < model.currentBook().count()) {
                model.setCurrentIndex(model.getCurrentIndex() + 1);
                updateCurrentView();
            }
        }
    }

    public void prev() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() - 1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() - 1);
                updateCurrentView();
            }
        }
    }

    public void importData() {
        join(view.importData());
    }

    public void exportData() {
        view.exportData(model);
    }
}
