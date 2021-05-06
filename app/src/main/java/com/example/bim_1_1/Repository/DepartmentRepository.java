package com.example.bim_1_1.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bim_1_1.DAO.DepartmentDao;
import com.example.bim_1_1.DAO.StudentDao;
import com.example.bim_1_1.Entities.Department;
import com.example.bim_1_1.Entities.Student;
import com.example.bim_1_1.RoomDB.StudentRoomDB;

import java.util.List;

public class DepartmentRepository {
    private DepartmentDao departmentDao;
    private LiveData<List<Department>> liveDataDepartment;

    public DepartmentRepository(Application application)
    {
        StudentRoomDB db =  StudentRoomDB.getDatabase(application.getApplicationContext());
        departmentDao = db.getDepartmentDao();
        liveDataDepartment =  departmentDao.getAllDepartments();
    }

    @Query("SELECT * FROM Department")
    public LiveData<List<Department>> getAllDepartments()
    {
        return liveDataDepartment;
    }

    public  LiveData<List<Department>> FindDepartmentById(int Id)
    {
        return  departmentDao.FindDepartmentById(Id);
    }

    public  LiveData<List<Department>> FindDepartmentByName(String name)
    {
        return  departmentDao.FindDepartmentByName(name);
    }

    public void Insert(Department  department)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            departmentDao.Insert(department);
        });
    }
    @Delete
    public void Delete(Department department)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            departmentDao.Delete(department);
        });
    }
    @Update
    public  void Update(Department department)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            departmentDao.Update(department);
        });
    }


}
