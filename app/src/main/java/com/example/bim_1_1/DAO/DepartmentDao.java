package com.example.bim_1_1.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bim_1_1.Entities.Department;
import com.example.bim_1_1.Entities.Student;

import java.util.List;

public interface DepartmentDao {
    @Insert
    void Insert(Department  department);
    @Delete
    void Delete(Department department);
    @Update
    void Update(Department student);

    @Query("SELECT * FROM Department")
    LiveData<List<Department>> getAllDepartments();

    @Query("SELECT * FROM Department WHERE DepartmentID = :Id")
    LiveData<List<Department>> FindDepartmentById(int Id);

    @Query("SELECT * FROM Department WHERE Name LIKE :name")
    LiveData<List<Department>> FindDepartmentByName(String name);
}
