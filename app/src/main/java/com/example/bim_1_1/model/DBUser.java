package com.example.bim_1_1.model;

import java.util.ArrayList;


public class DBUser {
    private static ArrayList<User> UserList;

    public DBUser() {
        UserList = new ArrayList<User>();
    }

    public int AddUser(User u)
    {
        UserList.add(u);
        return 1;
    }

    //Practice 1. show the list in a spinner in Home activity
    public ArrayList<User> GetAllUsers()
    {

        return UserList;
    }

    //3. from spinner user will select a name and click Delete
    public boolean deleteUser(String name){
        return true;
    }


    public static boolean Login(String email,String password)
    {
        boolean result=false;

        if (UserList!=null) {
            for (User user : UserList) {
                if (user.getEmail().toLowerCase().equals( email.toLowerCase()) && user.getPassword().equals(password)) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

}
