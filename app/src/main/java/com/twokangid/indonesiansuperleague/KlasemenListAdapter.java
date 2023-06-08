package com.twokangid.indonesiansuperleague;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twokangid.indonesiansuperleague.database.ModelDataKlub;

import java.util.ArrayList;
import java.util.List;

public class KlasemenListAdapter extends RecyclerView.Adapter<KlasemenViewHolder> {

    Context context;
    View view;
    ModelDataKlub modelDataKlub;
    int size = 0;

//    ArrayList <ModelDataKlub> list = new ArrayList<ModelDataKlub>();
    List<ModelDataKlub> list;

    public KlasemenListAdapter(Context context, List<ModelDataKlub>list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public KlasemenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        view = inflater
                .inflate(R.layout.klasemen_item,
                        parent, false);
         KlasemenViewHolder klasemenViewHolder = new KlasemenViewHolder(view);

        return klasemenViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KlasemenViewHolder holder, int position) {
        holder.noText.setText(String.valueOf(position + 1));
        holder.namaText.setText(list.get(position).getNama().toString());
        holder.mainText.setText(String.valueOf(list.get(position).getJumlahMain()));
        holder.menangText.setText(String.valueOf(list.get(position).getJumlahMenang()));
        holder.seriText.setText(String.valueOf(list.get(position).getJumlahSeri()));
        holder.kalahText.setText(String.valueOf(list.get(position).getJumlahKalah()));
        holder.goalText.setText(String.valueOf(list.get(position).getJumlahGoal()));
        holder.kebobolanText.setText(String.valueOf(list.get(position).getJumlahKebobolan()));
        holder.poinText.setText((String.valueOf(list.get(position).getPoin())));
        size++;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
