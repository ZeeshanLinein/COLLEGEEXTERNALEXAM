package com.teamlinein.oskartechnologies.exp1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.teamlinein.oskartechnologies.incomingcallreceiver.R;

public class Main4Activity extends AppCompatActivity {
EditText et_sender,et_message;
RelativeLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        et_message = (EditText)findViewById(R.id.et_message);
        et_sender = (EditText)findViewById(R.id.et_sender);
        layout = (RelativeLayout)findViewById(R.id.layout_parent) ;
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(et_sender.getText().toString(),null,et_message.getText().toString(),null,null);
                Snackbar.make(view, "Sending SMS", Snackbar.LENGTH_LONG)
                        .setAction("Cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(Main4Activity.this, "CLICKED ON CANCEL", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                layout.setBackgroundColor(Color.RED);
            break;
            case R.id.item2:
                layout.setBackgroundColor(Color.MAGENTA);
            break;
        }
        return true;
    }
}
