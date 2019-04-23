package com.teamlinein.oskartechnologies.fragments.ui.fragmentformain;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamlinein.oskartechnologies.incomingcallreceiver.R;


public class FragmentForMainActivity extends Fragment {

    private FragmentForMainViewModel mViewModel;

    public static FragmentForMainActivity newInstance() {
        return new FragmentForMainActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_for_main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentForMainViewModel.class);
        // TODO: Use the ViewModel
    }

}
