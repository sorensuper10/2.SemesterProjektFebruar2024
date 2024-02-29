package model;

public class Employee {

    private int employeeID;

    private String employeeName;

    private String employeeSurname;

    private String employeePhone;

    private String employeeMail;

    public Employee() {
    }

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public Employee(int employeeID, String employeeName, String employeeSurname, String employeePhone, String employeeMail) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeePhone = employeePhone;
        this.employeeMail = employeeMail;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeMail() {
        return employeeMail;
    }

    public void setEmployeeMail(String employeeMail) {
        this.employeeMail = employeeMail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                '}';
    }
}
