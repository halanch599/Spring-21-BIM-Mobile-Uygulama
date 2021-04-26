package com.example.bim_1_1.model;

public class Customer {
    int CustomerID;
    String FirstName;
    String LastName;

    public Customer(int customerID, String firstName, String lastName) {
        CustomerID = customerID;
        FirstName = firstName;
        LastName = lastName;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
