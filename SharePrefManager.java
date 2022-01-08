package com.example.miapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharePrefManager(Context context) {
        sharedPreferences = context.getSharedPreferences("com.example.sharedpreferences", context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        setAsDefaultValue();
    }

    /**
     * save value to db
     */
    private void setAsDefaultValue() {
        setUsername("aisi");
        setPassword("4381");
    }

    public void saveString(String value) {
        editor.putString("sp_string", value);
        editor.commit();
    }

    private void setUsername(String usernameValue) {
        editor.putString("sp_username", usernameValue).apply();
    }

    private void setPassword(String passwordValue) {
        editor.putString("sp_password", passwordValue).apply();
    }

    public void saveIsLogin(Boolean value) {
        editor.putBoolean("sp_islogin", value);
        editor.commit();
    }

    /**
     * get value from db
     */
    public String getString() {
        return sharedPreferences.getString("sp_string", "");
    }

    public String getUsername() {
        return sharedPreferences.getString("sp_username", "");
    }

    public String getPassword() {
        return sharedPreferences.getString("sp_password", "");
    }

    public boolean getIsLogin() {
        return sharedPreferences.getBoolean("sp_islogin", false);
    }
}
