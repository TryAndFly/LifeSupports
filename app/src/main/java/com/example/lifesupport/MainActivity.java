package com.example.lifesupport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculator(View view){
        Intent intent = new Intent(MainActivity.this,com.example.lifesupport.calculator.MainActivity.class);
        startActivity(intent);
    }
    public void calendars(View view){
        Log.d("test","准备开始");
        Intent intent = new Intent(MainActivity.this,com.example.lifesupport.calendar.MainActivity.class);
        startActivity(intent);
    }
    public void todolist(View view){
        Intent intent = new Intent(MainActivity.this,com.example.lifesupport.todolist.MainActivity.class);
        startActivity(intent);
    }

    public void FinanceManager(View view){
        Intent intent = new Intent(MainActivity.this,com.example.lifesupport.FinanceManager.MainActivity.class);
        startActivity(intent);
    }

    public void Information(View view){
        Intent intent = new Intent(MainActivity.this,com.example.lifesupport.Information.MainActivity.class);
        startActivity(intent);
    }
    public void clock(View view){
        Intent intent = new Intent(MainActivity.this,com.example.lifesupport.AlarmClock.MainActivity.class);
        startActivity(intent);
    }
}
