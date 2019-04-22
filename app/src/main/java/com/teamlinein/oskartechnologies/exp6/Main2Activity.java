package com.teamlinein.oskartechnologies.exp6;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.teamlinein.oskartechnologies.incomingcallreceiver.R;

public class Main2Activity extends AppCompatActivity {
LinearLayout layout;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

btn = (Button)findViewById(R.id.btn) ;
layout = (LinearLayout)findViewById(R.id.layout_parent);
        registerForContextMenu(btn);

        SharedPreferences sp = getSharedPreferences("ContextMenu",MODE_PRIVATE);
        int id =sp.getInt("id",-1);
        if (id != -1){
            switch (id){
                case R.id.image1:
                    layout.setBackgroundResource(R.drawable.ic_launcher_background);
                    break;
                case R.id.image2:
                    layout.setBackgroundResource(R.drawable.ic_launcher_foreground);
                    break;
                case R.id.remove:

                    layout.setBackgroundColor(Color.WHITE);
                    break;
            }
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.setbackgroundimage,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case R.id.image1:
                    SharedPreferences.Editor sp = getSharedPreferences("ContextMenu",MODE_PRIVATE).edit();
                    sp.putInt("id",R.id.image1);
                    sp.commit();
                    layout.setBackgroundResource(R.drawable.ic_launcher_background);
                    break;
                case R.id.image2:
                    SharedPreferences.Editor sp1 = getSharedPreferences("ContextMenu",MODE_PRIVATE).edit();
                    sp1.putInt("id",R.id.image2);
                    sp1.commit();
                    layout.setBackgroundResource(R.drawable.ic_launcher_foreground);
                    break;
                case R.id.remove:
                    SharedPreferences.Editor sp2 = getSharedPreferences("ContextMenu",MODE_PRIVATE).edit();
                    sp2.putInt("id",R.id.remove);
                    sp2.commit();
                    layout.setBackgroundColor(Color.WHITE);
                    break;
            }
        return true;
    }

}
