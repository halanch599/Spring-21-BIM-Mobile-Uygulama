package com.example.bim_1_1.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bim_1_1.DAO.StudentDao;
import com.example.bim_1_1.Entities.Student;
import com.example.bim_1_1.RoomDB.StudentRoomDB;

import java.util.List;

public class StudentRepository {
    private StudentDao studentDao;
    private LiveData<List<Student>> liveDataStudent;

    public StudentRepository(Application application)
    {
        StudentRoomDB db =  StudentRoomDB.getDatabase(application.getApplicationContext());
        studentDao = db.getStudentDao();
        liveDataStudent =  studentDao.getAllStudents();
    }

   public LiveData<List<Student>> getAllStudents()
    {
        return liveDataStudent;
    }


    public  LiveData<List<Student>> FindStudentById(int Id)
    {
        return studentDao.findStudentById(Id);
    }

    public  LiveData<List<Student>> FindStudentByName(String name)
    {
        return studentDao.findStudentByName(name);
    }

    public  void InsertStudent(Student std)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            studentDao.insertStudent(std);
        });

    }
    public  void DeleteStudent(Student student)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            studentDao.deleteStudent(student);
        });
    }
    public  void deleteAll()
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            studentDao.deleteAll();
        });
    }

    public  void UpdateStudent(Student student)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            studentDao.updateStudent(student);
        });
    }

}
