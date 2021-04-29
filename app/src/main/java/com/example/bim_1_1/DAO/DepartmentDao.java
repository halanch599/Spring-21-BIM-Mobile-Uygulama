package com.example.bim_1_1.DAO;

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

    @Insert
    void InsertDepartments(Department... department);

    @Delete
    void DeleteDepartment(Department student);

    @Delete
    void DeleteDepartments(Department... students);

    @Update
    void UpdateDepartment(Department student);

    @Query("SELECT * FROM Department")
    List<Student> getAllDepartments();

    @Query("SELECT * FROM Department WHERE DepartmentID = :Id")
    List<Student> FindDepartmentById(int Id);

    @Query("SELECT * FROM Department WHERE Name LIKE :name")
    List<Student> FindDepartmentByName(String name);
}
