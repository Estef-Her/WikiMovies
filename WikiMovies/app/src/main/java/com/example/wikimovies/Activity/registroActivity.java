package com.example.wikimovies.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.wikimovies.R;

public class registroActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        setFragment(1);
    }
    public void setFragment(int position){
        switch(position){
            case 1:
                FragmentManager fm3;
                FragmentTransaction ft3;
                fm3= getSupportFragmentManager();
                ft3=fm3.beginTransaction();
                ft3.replace(R.id.fragment_container, new registro_fragment());
                ft3.addToBackStack(null).commit();
                break;

        }
    }

    @Override
    public void onBackPressed() {

    }
}
