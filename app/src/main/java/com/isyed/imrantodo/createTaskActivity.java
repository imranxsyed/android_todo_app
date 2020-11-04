package com.isyed.imrantodo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class createTaskActivity extends AppCompatActivity {

    TextInputLayout taskDescription;
    Button saveTask;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_task_activity);

        saveTask = findViewById(R.id.btn_add_task);
        taskDescription = findViewById(R.id.til_task);


        saveTask.setOnClickListener(view ->{
            if (isTaskEmpty()){
                Toast.makeText(this, "No Task Provided", Toast.LENGTH_SHORT).show();
                return;
            }
            String input = taskDescription.getEditText().getText().toString();
            Intent responseIntent = new Intent();
            responseIntent.putExtra(MainActivity.EX_TASK_DESCRIPTION, input);
            setResult(RESULT_OK,responseIntent);
            finish();
        });
    }

    private boolean isTaskEmpty(){
        return taskDescription == null || taskDescription.getEditText().getText().toString().isEmpty();
    }
}