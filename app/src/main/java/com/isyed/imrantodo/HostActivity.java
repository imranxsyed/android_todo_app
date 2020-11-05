package com.isyed.imrantodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class HostActivity extends AppCompatActivity implements ITranser{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
    }

    @Override
    public void passData(String name) {
        if(null == name || name.isEmpty()){
            Toast.makeText(this, "No Name Provided", Toast.LENGTH_SHORT).show();
            return;
        }
        FragmentManager supportFragmentManager =
        getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_container_2, Fragment2.newInstance(name));
        fragmentTransaction.commit();
    }
}