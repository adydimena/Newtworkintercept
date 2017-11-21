package com.example.ady.newtworkintercept.AuxUtility;

import android.content.Context;

/**
 * Created by Ady on 11/19/2017.
 */

public class Item {
private String FirstName, LastName, Full_Name;

    public Item(String firstName, String lastName, String full_Name) {
        FirstName = firstName;
        LastName = lastName;
        Full_Name = full_Name;


    }


    public String getFirstName() {
        return FirstName;
    }


    public String getLastName() {
        return LastName;
    }



    public String getFull_Name() {
        return Full_Name;
    }




}
