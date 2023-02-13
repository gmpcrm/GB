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

public class CSVModel extends Model {
    private String path;

    public CSVModel(String path) {
        super();
        this.path = path;
    }

    public void load() {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            Phonebook currentBook = currentBook();
            String s = reader.readLine();
            while (s != null) {
                String[] strs = s.split(",");
                String fdate = strs[0]; 
                String firstName = strs[1];
                String lastName = strs[2];
                String phone = strs[3];
                String company = strs[4];
                String email = strs[5];            
                String description = strs[6];
                currentBook.add(new Contact(LocalDate.parse(fdate, Config.ofPattern()), firstName, lastName, phone, company, email, description));
                s = reader.readLine();
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
                StringBuilder sb = new StringBuilder();
                sb.append(contact.getDate().format(Config.ofPattern()));
                sb.append(",");
                sb.append(contact.getFirstName());
                sb.append(",");
                sb.append(contact.getLastName());
                sb.append(",");
                sb.append(contact.getPhone());
                sb.append(",");
                sb.append(contact.getCompany());
                sb.append(",");
                sb.append(contact.getEmail());
                sb.append(",");
                sb.append(contact.getDescription());
                writer.append(sb.toString());
                writer.append("\n");
            }

            writer.append("\n");
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}