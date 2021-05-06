package com.example.bim_1_1.RoomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bim_1_1.DAO.DepartmentDao;
import com.example.bim_1_1.DAO.StudentDao;
import com.example.bim_1_1.Entities.Department;
import com.example.bim_1_1.Entities.Student;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// Singleton Pattern: sadace bir object olusturabilir
@Database(entities = {Student.class, Department.class}, version = 1, exportSchema = false)
public abstract class StudentRoomDB extends RoomDatabase {

    // getters
    public abstract StudentDao getStudentDao();
    public abstract DepartmentDao getDepartmentDao();

    private static  StudentRoomDB INSTANCE;

    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(5);

    public static StudentRoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (StudentRoomDB.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        StudentRoomDB.class, "sms")
                        //lutfen yapmayin
//                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }



}
