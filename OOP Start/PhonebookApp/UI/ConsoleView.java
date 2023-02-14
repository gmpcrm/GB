package PhonebookApp.UI;

import java.time.LocalDate;
import java.util.Scanner;

import PhonebookApp.Config;
import PhonebookApp.Core.MVP.View;

public class ConsoleView implements View {
    Scanner in;
    public ConsoleView() {
        in = new Scanner(System.in, "Cp866");
    }

    @Override
    public LocalDate getDate() {
        System.out.printf("Date in format [%s]: ", Config.dateFormat);
        return LocalDate.parse(in.nextLine(), Config.ofPattern());
    }

    @Override
    public void setDate(LocalDate value) {
        System.out.printf("Date: %s\n", value.format(Config.ofPattern()));
    }

    @Override
    public String getFirstName() {
        System.out.printf("FirstName: ");
        return in.nextLine();
    }

    @Override
    public void setFirstName(String value) {
        System.out.printf("FirstName: %s\n", value);
    }

    @Override
    public String getLastName() {
        System.out.printf("LastName: ");
        return in.nextLine();
    }

    @Override
    public void setLastName(String value) {
        System.out.printf("LastName: %s\n", value);
    }

    @Override
    public String getPhone() {
        System.out.printf("Phone: ");
        return in.nextLine();
    }

    @Override
    public void setPhone(String value) {
        System.out.printf("Phone: %s\n", value);
    }

    @Override
    public String getCompany() {
        System.out.printf("Company: ");
        return in.nextLine();
    }

    @Override
    public void setCompany(String value) {
        System.out.printf("Company: %s\n", value);
    }

    @Override
    public String getEmail() {
        System.out.printf("Email: ");
        return in.nextLine();
    }

    @Override
    public void setEmail(String value) {
        System.out.printf("Email: %s\n", value);
    }

    @Override
    public String getDescription() {
        System.out.printf("Description: ");
        return in.nextLine();
    }

    @Override
    public void setDescription(String value) {
        System.out.printf("Description: %s\n", value);
        System.out.println();      
    }
    
    @Override
    public String[] getImportInfo() {
        System.out.println("0 return, 1 Import from CSV, 2 Import from TXT");
        String key = in.next();
        while (true) {
            switch (key) {
                case "0":
                    return null;
                case "1":
                    return new String[] {"csv", in.next()};
                case "2":
                    return new String[] {"txt", in.next()};
                default:
                    System.out.println("No such command");
                    break;
            }
        }
    }

    @Override
    public String[] getExportInfo() {
        System.out.println("0 return, 1 Export to CSV, 2 Export to TXT");
        String key = in.next();
        while (true) {
            switch (key) {
                case "0":
                    return null;
                case "1":
                    return new String[] {"csv", in.next()};
                case "2":
                    return new String[] {"txt", in.next()};
                default:
                    System.out.println("No such command");
                    break;
            }
        }
    }

    @Override
    public String[] getSearchInfo() {
        System.out.print("Enter query string: ");
        String key = in.next();
        return new String[] { key };
    }
}
