package com.teamlinein.oskartechnologies.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.teamlinein.oskartechnologies.fragments.ui.fragmentformain.Fragment2ForMainActivity;
import com.teamlinein.oskartechnologies.fragments.ui.fragmentformain.FragmentForMainActivity;
import com.teamlinein.oskartechnologies.incomingcallreceiver.R;

public class MainActivityFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FragmentForMainActivity.newInstance())
                    .commitNow();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_02, Fragment2ForMainActivity.newInstance())
                    .commitNow();
        }
    }
}
