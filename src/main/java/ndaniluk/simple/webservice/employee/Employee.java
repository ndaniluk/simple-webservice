package ndaniluk.simple.webservice.employee;

import java.util.Date;

public class Employee {

    private int id;

    private String name;

    private String surname;

    private Date employmentDate;

    private String phoneNumber;

    protected Employee() {}

    public Employee(int id, String name, String surname, Date employmentDate, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.employmentDate = employmentDate;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", employmentDate=" + employmentDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
