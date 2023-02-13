package PhonebookApp.Core.Models;

import java.time.LocalDate;

public class Contact  implements Comparable<Contact> {
    private LocalDate date;
    private String firstName;
    private String lastName;
    private String phone;
    private String company;
    private String email;
    private String description;

    public Contact(LocalDate date, String firstName, String lastName, String phone, String company, String email, String description) {
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.company = company;
        this.email = email;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "date=" + date +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(Contact o) {
        return this.getFirstName().compareTo(o.getFirstName()) == 0 ?
                this.getLastName().compareTo(o.getLastName()) == 0 ?
                        this.getPhone().compareTo(o.getPhone()) == 0 ?
                                this.getCompany().compareTo(o.getCompany()) == 0 ?
                                        this.getEmail().compareTo(o.getEmail()) == 0 ?
                                                this.getDescription().compareTo(o.getDescription()) == 0 ?
                                                        this.getDate().compareTo(o.getDate()) : this.getDescription().compareTo(o.getDescription())
                                                : this.getEmail().compareTo(o.getEmail())
                                        : this.getCompany().compareTo(o.getCompany())
                                : this.getPhone().compareTo(o.getPhone())
                        : this.getLastName().compareTo(o.getLastName())
                : this.getFirstName().compareTo(o.getFirstName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (date != null ? !date.equals(contact.date) : contact.date != null) return false;
        if (firstName != null ? !firstName.equals(contact.firstName) : contact.firstName != null) return false;
        if (lastName != null ? !lastName.equals(contact.lastName) : contact.lastName != null) return false;
        if (phone != null ? !phone.equals(contact.phone) : contact.phone != null) return false;
        if (company != null ? !company.equals(contact.company) : contact.company != null) return false;
        if (email != null ? !email.equals(contact.email) : contact.email != null) return false;
        return description != null ? description.equals(contact.description) : contact.description == null;
    }
}