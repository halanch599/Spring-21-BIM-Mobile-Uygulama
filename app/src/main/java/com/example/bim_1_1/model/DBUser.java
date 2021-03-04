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

    public ArrayList<User> GetAllUsers()
    {
        return UserList;
    }
}
