package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnOnClick(View view) {
        Button btn = (Button)view;
        Class myClass = null;
        if(btn.getText().equals(getResources().getString(R.string.task1_name))) {
            myClass = Task1Activity.class;
        }
        else if(btn.getText().equals(getResources().getString(R.string.task2_name))) {
            myClass = Task2Activity.class;
        }
        else if(btn.getText().equals(getResources().getString(R.string.task3_name))) {
            myClass = Task3Activity.class;
        }
        else if(btn.getText().equals(getResources().getString(R.string.task4_name))) {
            myClass = Task4Activity.class;
        }
        else if(btn.getText().equals(getResources().getString(R.string.task5_name))) {
            myClass = Task5Activity.class;
        }
        else if(btn.getText().equals(getResources().getString(R.string.task6_name))) {
            myClass = Task6Activity.class;
        }

        if(myClass != null) {
            Intent intent = new Intent(MainActivity.this, myClass);
            startActivity(intent);
        }
    }
}
