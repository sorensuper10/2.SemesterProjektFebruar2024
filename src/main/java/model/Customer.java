package model;

public class Customer {
    private int customerID;
    private static String customerName;
    private String customerSurname;
    private String customerPhone;
    private String customerMail;

    public Customer() {
    }

    public Customer(int customerID, String customerName, String customerSurname, String customerPhone, String customerMail) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerPhone = customerPhone;
        this.customerMail = customerMail;
    }

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public static String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", name='" + customerName + '\'' +
                ", surname='" + customerSurname + '\'' +
                ", phone='" + customerPhone + '\'' +
                ", mail='" + customerMail + '\'' +
                '}';
    }
}
