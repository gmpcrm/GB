package PhonebookApp.Core.MVP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import PhonebookApp.Config;
import PhonebookApp.Core.Infrastructure.Phonebook;
import PhonebookApp.Core.Models.Contact;

public class PlainTextModel extends Model {
    private String path;

    public PlainTextModel(String path) {
        super();
        this.path = path;
    }

    public void load() {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            Phonebook currentBook = currentBook();
            String fdate = reader.readLine();
            while (fdate != null) {
                String firstName = reader.readLine();
                String lastName = reader.readLine();
                String phone = reader.readLine();
                String company = reader.readLine();
                String email = reader.readLine();                
                String description = reader.readLine();
                currentBook.add(new Contact(LocalDate.parse(fdate, Config.ofPattern()), firstName, lastName, phone, company, email, description));
                fdate = reader.readLine();
            }

            reader.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void save() {
        try (FileWriter writer = new FileWriter(path, false)) {
            Phonebook currentBook = currentBook();
            for (int i = 0; i < currentBook.count(); i++) {
                Contact contact = currentBook.getContact(i);
                writer.append(String.format("%s\n", contact.getDate().format(Config.ofPattern())));
                writer.append(String.format("%s\n", contact.getFirstName()));
                writer.append(String.format("%s\n", contact.getLastName()));
                writer.append(String.format("%s\n", contact.getPhone()));
                writer.append(String.format("%s\n", contact.getCompany()));
                writer.append(String.format("%s\n", contact.getEmail()));
                writer.append(String.format("%s\n", contact.getDescription()));                
            }

            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}