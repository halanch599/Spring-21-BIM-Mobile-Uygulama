package com.example.bim_1_1.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelperCustomer extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bankDB.db";

    private static final String TABLE_NAME = "Customer";
    private static final String COLUMN_CUSTOMERID = "CustomerID";
    private static final String COLUMN_FIRSTNAME = "FirstName";
    private static final String COLUMN_LASTNAME = "LastName";


    private static final String SQL_CREATE_TABLE_CUSTOMER =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_CUSTOMERID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_FIRSTNAME + " TEXT," +
                    COLUMN_LASTNAME + " TEXT)";

    private static final String SQL_DELETE_TABLE_CUSTOMER =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


    public DbHelperCustomer(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_CUSTOMER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        //onUpgrade(sqLiteDatabase,oldversion,newversion);
        sqLiteDatabase.execSQL(SQL_DELETE_TABLE_CUSTOMER);
        onCreate(sqLiteDatabase);
    }

    public long CustomerAdd(Customer c){
        SQLiteDatabase db = this.getWritableDatabase();
        try{

            ContentValues cv = new ContentValues();
            cv.put(COLUMN_FIRSTNAME,c.getFirstName());
            cv.put(COLUMN_LASTNAME,c.getLastName());

         return db.insert(TABLE_NAME,null,cv);

        }
        catch (Exception ex)
        {
            return  -1;
        }
        finally {
            db.close();
        }
    }

    public ArrayList<Customer> CustomerGetAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=null;
        try{

            if (db==null)
            {
                throw new Exception("Database is not found.");
            }

            String query="SELECT * FROM " + TABLE_NAME;
            cursor = db.rawQuery(query,null);

            ArrayList<Customer> customers = new ArrayList<>();
            while (cursor.moveToNext()){
                int CID = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_CUSTOMERID));
                String fname =  cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FIRSTNAME));
                String lname = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LASTNAME));

                customers.add(new Customer(CID,fname,lname));
            }
            return customers;
        }
        catch (Exception ex)
        {
            return  null;
        }
        finally {
            db.close();
        }
    }
}
