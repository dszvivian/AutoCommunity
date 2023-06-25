package com.example.autocommunity;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    static final String USERNAME = "username" ;
    static final String SP = "sp" ;

    public void saveData(Context context,String username){
        SharedPreferences sp = context.getSharedPreferences(SP,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(USERNAME,username);
        editor.apply();
    }

    public String isLoggedIn(Context context){
        SharedPreferences sp = context.getSharedPreferences(SP,Context.MODE_PRIVATE);
        return sp.getString(USERNAME,"");
    }


}
