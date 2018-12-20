package com.example.administrator.stockoptionallist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListOptionalFragment listOptionalFragment = new ListOptionalFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_option_container, listOptionalFragment).commitAllowingStateLoss();
    }
}
