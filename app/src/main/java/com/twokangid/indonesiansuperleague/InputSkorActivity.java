package com.twokangid.indonesiansuperleague;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.twokangid.indonesiansuperleague.database.DatabaseHandler;
import com.twokangid.indonesiansuperleague.database.ModelDataKlub;

import java.util.ArrayList;

public class InputSkorActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ClickListener listener;
    skorListAdapter adapter;
    ArrayList<String> listKlub = new ArrayList<String>();
    DatabaseHandler databaseHandler;
    ModelDataKlub modelDataKlub;

    Button tambahBtn, kurangBtn, simpanBtn;
    int size = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_skor);

        recyclerView = findViewById(R.id.recycler_view);
        tambahBtn = findViewById(R.id.tambah_btn);
        kurangBtn = findViewById(R.id.kurang_btn);
        simpanBtn = findViewById(R.id.simpan_btn);

        databaseHandler = new DatabaseHandler(getApplicationContext());

        listener = new ClickListener(){
            @Override
            public void click(int index){
                Toast.makeText(InputSkorActivity.this,"clicked item index is "+index, Toast.LENGTH_LONG).show();
            }
        };

        callAdapter(size);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            int count = recyclerView.getAdapter().getItemCount()-1;
            int menangA, menangB, kalahA, kalahB, seriA, seriB, goalA, goalB, poinA, poinB;
            @Override
            public void onClick(View view) {
                Toast.makeText(InputSkorActivity.this, String.valueOf(count), Toast.LENGTH_LONG).show();
                for(int i = 0; i <= count + 1;i++){
                    menangA = 0;
                    menangB = 0;
                    kalahA = 0;
                    kalahB = 0;
                    seriA = 0;
                    seriB = 0;
                    goalA = 0;
                    goalB = 0;
                    poinA = 0;
                    poinB = 0;
                    try {
                        RecyclerView.ViewHolder holder = recyclerView.findViewHolderForAdapterPosition(i);

                        Spinner klubA = holder.itemView.findViewById(R.id.nama_klub_a);
                        Spinner klubB = holder.itemView.findViewById(R.id.nama_klub_b);

                        EditText skorA = holder.itemView.findViewById(R.id.skor_a);
                        EditText skorB = holder.itemView.findViewById(R.id.skor_b);

                        goalA = Integer.parseInt(skorA.getText().toString());
                        goalB = Integer.parseInt(skorB.getText().toString());

                        ModelDataKlub inputDataKlub = databaseHandler.getClubRecord(klubA.getSelectedItem().toString());

                        if(goalA > goalB){
                            menangA += 1;
                            kalahB += 1;
                        }else if(goalA < goalB){
                            menangB += 1;
                            kalahA += 1;
                        }else{
                            seriA += 1;
                            seriB += 1;
                        }

                        poinA = (3 * menangA) + (1 * seriA) + (0 * kalahA);
                        poinB = (3 * menangB) + (1 * seriB) + (0 * kalahB);

                        inputDataKlub.setJumlahMain(inputDataKlub.getJumlahMain()+1);
                        inputDataKlub.setJumlahMenang(inputDataKlub.getJumlahMenang()+menangA);
                        inputDataKlub.setJumlahSeri(inputDataKlub.getJumlahSeri()+seriA);
                        inputDataKlub.setJumlahKalah(inputDataKlub.getJumlahKalah()+kalahA);
                        inputDataKlub.setJumlahGoal(inputDataKlub.getJumlahGoal()+goalA);
                        inputDataKlub.setJumlahKebobolan(inputDataKlub.getJumlahKebobolan()+goalB);
                        inputDataKlub.setPoin(inputDataKlub.getPoin()+poinA);

                        databaseHandler.updateRecord(inputDataKlub);

                        ModelDataKlub inputDataKlubB = databaseHandler.getClubRecord(klubB.getSelectedItem().toString());

                        inputDataKlubB.setJumlahMain(inputDataKlub.getJumlahMain()+1);
                        inputDataKlubB.setJumlahMenang(inputDataKlub.getJumlahMenang()+menangB);
                        inputDataKlubB.setJumlahSeri(inputDataKlub.getJumlahSeri()+seriB);
                        inputDataKlubB.setJumlahKalah(inputDataKlub.getJumlahKalah()+kalahB);
                        inputDataKlubB.setJumlahGoal(inputDataKlub.getJumlahGoal()+goalB);
                        inputDataKlubB.setJumlahKebobolan(inputDataKlub.getJumlahKebobolan()+goalA);
                        inputDataKlubB.setPoin(inputDataKlub.getPoin()+poinB);

                        databaseHandler.updateRecord(inputDataKlubB);

                        String namaKlubA = klubA.getSelectedItem().toString();
                        String namaKlubB = klubA.getSelectedItem().toString();

//                        Toast.makeText(getApplicationContext(), nama, Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    }
                }


            }
        });

        tambahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size += 1;
                callAdapter(size);
            }
        });

        kurangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size -= 1;
                if (size < 1){
                    size = 1;
                }
                callAdapter(size);
            }
        });

    }

    public void callAdapter(int size){
        adapter = new skorListAdapter(databaseHandler.getAllClub() ,getApplication(), listener, size);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(InputSkorActivity.this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(InputSkorActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}