package com.example.bim_1_1.RoomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bim_1_1.DAO.DepartmentDao;
import com.example.bim_1_1.DAO.StudentDao;
import com.example.bim_1_1.Entities.Department;
import com.example.bim_1_1.Entities.Student;


// Singleton Pattern: sadace bir object olusturabilir
@Database(entities = {Student.class, Department.class}, version = 1, exportSchema = false)
public abstract class StudentRoomDB extends RoomDatabase {

    public abstract StudentDao getStudentDao();
    public abstract DepartmentDao getDepartmentDao();

    private static  StudentRoomDB INSTANCE;

    public static StudentRoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {

            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    StudentRoomDB.class, "sms")
                    .build();
        }
        return INSTANCE;
    }



}
