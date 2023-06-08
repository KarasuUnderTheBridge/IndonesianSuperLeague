package com.twokangid.indonesiansuperleague;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.twokangid.indonesiansuperleague.database.DatabaseHandler;

public class MainActivity extends AppCompatActivity {

    DatabaseHandler databaseHandler;
    Button inputDataBtn, inputSkorBtn, klasemenBtn;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputDataBtn = findViewById(R.id.input_klub_btn);
        inputSkorBtn = findViewById(R.id.input_skor_btn);
        klasemenBtn = findViewById(R.id.klasemen_btn);

        databaseHandler = new DatabaseHandler(getApplicationContext());


//      Pindah Halaman
        inputDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InputDataActivity.class);
                startActivity(intent);
                finish();
            }
        });
        inputSkorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InputSkorActivity.class);
                startActivity(intent);
                finish();
            }
        });
        klasemenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, KlasemenActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}