package com.teamlinein.oskartechnologies.sqlite;

import android.widget.Toast;

public class POJO {
    String Email,Password;
  final   String Table_name = "user";
    final String COL_EMAIL = "email";
    final String COL_PASSWORD = "pass";
    final String SQL_QUERY = "CREATE TABLE "+Table_name +" ( "+
        COL_EMAIL+ " text , " +
        COL_PASSWORD +" text )";

    public POJO() {
    }

    public POJO(String email, String password) {
        Email = email;
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
