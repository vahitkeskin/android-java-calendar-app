package com.vahitkeskin.mycalendarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView myDate;
    Button btn_saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendar);
        myDate = findViewById(R.id.my_date);
        btn_saved = findViewById(R.id.btn_saved);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                //Selected Date
                Intent intent = new Intent(getApplicationContext(), EditActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Yıl : "+i+"\n"+"Ay : "+i1+"\n"+"Gün : "+i2, Toast.LENGTH_LONG).show();
            }
        });

        btn_saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NotesActivity.class);
                startActivity(intent);
            }
        });
    }
}