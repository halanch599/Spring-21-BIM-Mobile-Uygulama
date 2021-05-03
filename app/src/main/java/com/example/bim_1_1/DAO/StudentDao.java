package com.example.bim_1_1.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bim_1_1.Entities.Student;

import java.util.List;

public interface StudentDao {
    @Insert
    void InsertStudent(Student std);

    @Insert
    void InsertStudents(Student... students);

    @Delete
    void DeleteStudent(Student student);

    @Delete
    void DeleteStudents(Student... students);

    @Update
    void UpdateStudent(Student student);

    @Query("SELECT * FROM STUDENT Order BY First_Name")
    LiveData<List<Student>> getAllStudents();

    @Query("SELECT * FROM STUDENT WHERE StudnetID = :Id")
    LiveData<List<Student>> FindStudentById(int Id);

    @Query("SELECT * FROM STUDENT WHERE First_Name LIKE :name OR Last_Name LIKE :name")
    LiveData<List<Student>> FindStudentByName(String name);
}
