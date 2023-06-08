package com.twokangid.indonesiansuperleague;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.twokangid.indonesiansuperleague.database.DatabaseHandler;
import com.twokangid.indonesiansuperleague.database.ModelDataKlub;

public class InputDataActivity extends AppCompatActivity {
    Button simpanBtn;
    EditText namaKlubEdit, asalKlubEdit;

    DatabaseHandler databaseHandler;
    ModelDataKlub modelDataKlub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        simpanBtn = findViewById(R.id.simpan_btn);
        namaKlubEdit = findViewById(R.id.nama_klub_edit);
        asalKlubEdit = findViewById(R.id.asal_klub_edit);
        databaseHandler = new DatabaseHandler(getApplication());

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelDataKlub = new ModelDataKlub(namaKlubEdit.getText().toString(), asalKlubEdit.getText().toString());

                try {
                    if(databaseHandler.addRecord(modelDataKlub)){
                        Toast.makeText(getApplicationContext(), "Data Klub sudah ada!", Toast.LENGTH_LONG).show();
                    }else if(!databaseHandler.addRecord(modelDataKlub)){
                        Toast.makeText(getApplicationContext(), "Data berhasil dimasukan!", Toast.LENGTH_LONG).show();
                        namaKlubEdit.setText("");
                        asalKlubEdit.setText("");
                    }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(InputDataActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}