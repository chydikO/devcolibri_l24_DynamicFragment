package com.chudnovskiy.devcolibri_l24_dynamicfragment.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chudnovskiy.devcolibri_l24_dynamicfragment.R;

public class OneFragment extends Fragment {
    public static final String TAG = "OneFragmentKey";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one_layout, null);
    }
}
