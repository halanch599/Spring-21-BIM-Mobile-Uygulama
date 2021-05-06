package com.example.bim_1_1.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bim_1_1.Entities.Student;
import com.example.bim_1_1.Repository.StudentRepository;
import com.example.bim_1_1.RoomDB.StudentRoomDB;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {

    private StudentRepository studentRepository;
    private  LiveData<List<Student>> liveDataStudent;

    public StudentViewModel(@NonNull Application application) {
        super(application);

        studentRepository =  new StudentRepository(application);
        liveDataStudent = studentRepository.getAllStudents();
    }

    public LiveData<List<Student>> getAllStudents()
    {
        return liveDataStudent;
    }


    public  LiveData<List<Student>> FindStudentById(int Id)
    {
        return studentRepository.FindStudentById(Id);
    }

    public  LiveData<List<Student>> FindStudentByName(String name)
    {
        return studentRepository.FindStudentByName(name);
    }

    public  void InsertStudent(Student std)
    {
            studentRepository.InsertStudent(std);
    }
    public  void DeleteStudent(Student student)
    {
            studentRepository.DeleteStudent(student);
    }
    public  void deleteAll()
    {
            studentRepository.deleteAll();
    }

    public  void UpdateStudent(Student student)
    {
            studentRepository.UpdateStudent(student);
    }
}
