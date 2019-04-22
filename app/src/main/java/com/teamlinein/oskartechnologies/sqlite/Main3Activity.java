package com.teamlinein.oskartechnologies.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.teamlinein.oskartechnologies.incomingcallreceiver.R;

public class Main3Activity extends AppCompatActivity {
EditText et_email , et_password;
Database db;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        et_email = (EditText)findViewById(R.id.et_email);
        et_password = (EditText)findViewById(R.id.et_pass);
        db = new Database(this);
    }

    public void performLogin(View view) {
    POJO p =db.loginUser(new POJO(et_email.getText().toString(),et_password.getText().toString()));
        Toast.makeText(this, p.getPassword(), Toast.LENGTH_SHORT).show();
}

    public void performRegister(View view) {
        long id = db.registerUser(new POJO(et_email.getText().toString(),et_password.getText().toString()));
        Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();
}
}
