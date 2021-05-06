package com.example.bim_1_1.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bim_1_1.Entities.Department;
import com.example.bim_1_1.Repository.DepartmentRepository;
import com.example.bim_1_1.RoomDB.StudentRoomDB;

import java.util.List;

public class DepartmentViewModel extends AndroidViewModel {

    private DepartmentRepository departmentRepository;
    private LiveData<List<Department>> liveDataDepartment;


    public DepartmentViewModel(@NonNull Application application) {
        super(application);

        departmentRepository =  new DepartmentRepository(application);
        liveDataDepartment = departmentRepository.getAllDepartments();
    }

    @Query("SELECT * FROM Department")
    public LiveData<List<Department>> getAllDepartments()
    {
        return liveDataDepartment;
    }

    public  LiveData<List<Department>> FindDepartmentById(int Id)
    {
        return  departmentRepository.FindDepartmentById(Id);
    }

    public  LiveData<List<Department>> FindDepartmentByName(String name)
    {
        return  departmentRepository.FindDepartmentByName(name);
    }

    public void Insert(Department  department)
    {
            departmentRepository.Insert(department);
    }
    public void Delete(Department department)
    {
            departmentRepository.Delete(department);
    }
    public  void Update(Department department)
    {
            departmentRepository.Update(department);
    }
}
