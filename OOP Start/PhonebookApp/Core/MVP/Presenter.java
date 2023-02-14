package PhonebookApp.Core.MVP;

import java.util.List;

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

    private Model createModel(String type, String path)
    {
        Model model = null;
        if (type.equals("csv")) {
            model = new CSVModel(path);
        }
        else if (type.equals("txt")) {
            model = new PlainTextModel(path);
        }
        else {
            throw new IllegalArgumentException("Unknown model type");
        }

        return model;
    }

    public void importData() {
        String[] info = view.getImportInfo();
        if (info != null){
            Model model = createModel(info[0], info[1]);
            model.load();
            join(model);
        }
    }

    public void exportData() {
        String[] info = view.getExportInfo();
        if (info != null){
            Model model = createModel(info[0], info[1]);
            model.join(this.model);
            model.save();
        }
   }

   public void search() {
        String[] info = view.getSearchInfo();
        if (info != null){
            List<Integer> result = model.search(info);
            if (result.size() > 0) {
                model.setCurrentIndex(result.get(0));
                updateCurrentView();
            }
        }
   }
}
