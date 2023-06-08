package com.twokangid.indonesiansuperleague;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.twokangid.indonesiansuperleague.database.DatabaseHandler;

public class KlasemenActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    KlasemenListAdapter adapter;
    DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klasemen);

        recyclerView = findViewById(R.id.recycler_view1);

        databaseHandler = new DatabaseHandler(getApplicationContext());

        adapter = new KlasemenListAdapter(getApplication(), databaseHandler.getAllRecord() );

        Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemCount()), Toast.LENGTH_LONG).show();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(KlasemenActivity.this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(KlasemenActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}