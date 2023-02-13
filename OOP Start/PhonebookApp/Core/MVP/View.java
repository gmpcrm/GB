package PhonebookApp.Core.MVP;

import java.time.LocalDate;

public interface View {
    LocalDate getDate();
    void setDate(LocalDate value);
    String getFirstName();    
    void setFirstName(String value);
    String getLastName();
    void setLastName(String value);
    String getPhone();
    void setPhone(String value);
    String getCompany();
    void setCompany(String value);
    String getEmail();
    void setEmail(String value);
    String getDescription();
    void setDescription(String value);
    Model importModel(String mode, String path);
    void exportModel(Model source, String mode, String path);
    Model importData();
    void exportData(Model source);
}