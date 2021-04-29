package com.example.bim_1_1.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Student")
public class Student {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    int StudnetID;

    @NonNull
    @ColumnInfo(name = "First_Name")
    String FirstName;
    @ColumnInfo(name = "Last_Name")
    String LastName;
    String Address;


    public Student(int studnetID, String firstName, String lastName, String address) {
        StudnetID = studnetID;
        FirstName = firstName;
        LastName = lastName;
        Address = address;
    }

    public Student(String firstName, String lastName, String address) {
        FirstName = firstName;
        LastName = lastName;
        Address = address;
    }


    public int getStudnetID() {
        return StudnetID;
    }

    public void setStudnetID(int studnetID) {
        StudnetID = studnetID;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


}
