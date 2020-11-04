package com.isyed.imrantodo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*EditText inputTask;
    Button saveTask;*/
    ListView tasks;
    FloatingActionButton addTask;
    ArrayAdapter<String> task_adapter;
    public static final String EX_TASK_DESCRIPTION = "com.isyed.imrantodo.TASK_DESCRIPTION";
    public static final int INT_RC_ADD_TASK = 1920;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding the fields
      /*  inputTask = findViewById(R.id.et_edit);
        saveTask = findViewById(R.id.btn_savetask);*/

        addTask = findViewById(R.id.fab_add_activity);
        tasks = findViewById(R.id.lv_task);
        task_adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        tasks.setAdapter(task_adapter);


//        saveTask.setOnClickListener(this);
        addTask.setOnClickListener(this);


        tasks.setOnItemLongClickListener((adapter_view,view,position,id) -> {
            task_adapter.remove(task_adapter.getItem(position));
            return true;
        });





    }

    @Override
    public void onClick(View v) {

        if (v.getId() == addTask.getId()){
            Intent requestIntent = new Intent();
            requestIntent.setClass(this,createTaskActivity.class);

            startActivityForResult(requestIntent,INT_RC_ADD_TASK);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == INT_RC_ADD_TASK){

            if (resultCode == RESULT_OK){
                addToAdapter(data.getStringExtra(EX_TASK_DESCRIPTION));
            }else{
                Toast.makeText(this, "Something went wrong creating a task", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void addToAdapter(String task){
        task_adapter.add(task);
    }
}