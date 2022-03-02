package com.chudnovskiy.devcolibri_l24_dynamicfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.chudnovskiy.devcolibri_l24_dynamicfragment.fragment.OneFragment;
import com.chudnovskiy.devcolibri_l24_dynamicfragment.fragment.TwoFragment;

public class MainActivity extends FragmentActivity {
    private Button addFragmentButton;
    private Button deleteFragmentButton;
    private Button replaceFragmentButton;
    private Switch isBackStageSwitch;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragmentButton = (Button) findViewById(R.id.button_add_fragment);
        deleteFragmentButton = (Button) findViewById(R.id.button_del_fragment);
        replaceFragmentButton = (Button) findViewById(R.id.button_replace_fragment);
        isBackStageSwitch = (Switch) findViewById(R.id.switch_back_stage);

        fragmentManager = getSupportFragmentManager();

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();

        View.OnClickListener onClickListener = view -> {
            fragmentTransaction = fragmentManager.beginTransaction();
            switch (view.getId()) {
                case R.id.button_add_fragment:
                    if (fragmentManager.findFragmentByTag(OneFragment.TAG) == null) {
                        fragmentTransaction.add(R.id.container, oneFragment, OneFragment.TAG)
                    }
                    break;
                case R.id.button_del_fragment:
                    if (fragmentManager.findFragmentByTag(OneFragment.TAG) != null) {
                        fragmentTransaction.remove(oneFragment);
                    }
                    if (fragmentManager.findFragmentByTag(TwoFragment.TAG) != null) {
                        fragmentTransaction.remove(twoFragment);
                    }
                    break;
                case R.id.button_replace_fragment:
                    if (null != fragmentManager.findFragmentByTag(OneFragment.TAG)) {
                        fragmentTransaction.replace(R.id.container, twoFragment, twoFragment.TAG);
                    }
                    if (fragmentManager.findFragmentByTag(TwoFragment.TAG) != null) {
                        fragmentTransaction.replace(R.id.container, oneFragment, oneFragment.TAG);
                    }
                    break;
            }
            if (isBackStageSwitch.isChecked()) {
                fragmentTransaction.addToBackStack(null);
            }
            fragmentTransaction.commit();
        };
        addFragmentButton.setOnClickListener(onClickListener);
        deleteFragmentButton.setOnClickListener(onClickListener);
        replaceFragmentButton.setOnClickListener(onClickListener);
    }
}