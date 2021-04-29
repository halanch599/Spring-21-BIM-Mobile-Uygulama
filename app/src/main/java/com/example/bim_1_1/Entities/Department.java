package com.example.bim_1_1.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Department {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    int DepartmentID;
    String Name;

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int departmentID) {
        DepartmentID = departmentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Department(int departmentID, String name) {
        DepartmentID = departmentID;
        Name = name;
    }
}
