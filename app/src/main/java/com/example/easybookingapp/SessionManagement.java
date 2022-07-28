package com.example.easybookingapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.easybookingapp.Model.login;

public class SessionManagement {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_user";

    public SessionManagement(Context context){
        sharedPreferences= context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public void removeSession(){
        editor.putInt(SESSION_KEY,-1).commit();
    }

    public  void saveSession(login loginUser){
// graba la session
        String user = loginUser.getNombre();
        if (user != null){
            editor.putInt(SESSION_KEY, 1).commit();
        }else{

        }
    }

    public int getSession(){
        //return user whose session is saved
return sharedPreferences.getInt(SESSION_KEY,-1) ;

    }
}
