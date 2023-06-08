package com.twokangid.indonesiansuperleague;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twokangid.indonesiansuperleague.database.DatabaseHandler;
import com.twokangid.indonesiansuperleague.database.ModelDataKlub;

import java.util.ArrayList;

public class skorListAdapter extends RecyclerView.Adapter<skorViewHolder>{
    Context context;
    ClickListener listener;
    int size;
    View view;

    ArrayList<ModelDataKlub> listKlub = new ArrayList<ModelDataKlub>();

    DatabaseHandler handler = new DatabaseHandler(context);
    ModelDataKlub modelDataKlub;

    ArrayList<String> list = new ArrayList<String>();

    public skorListAdapter(ArrayList <String> list, Context context, ClickListener listener, int size) {
        this.list = list;
        this.context = context;
        this.listener = listener;
        this.size = size;
    }

    public ArrayList<ModelDataKlub>getArrayList(skorViewHolder holder){
        return listKlub;
    }

    @NonNull
    @Override
    public skorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        view = inflater
                .inflate(R.layout.input_skor_item,
                        parent, false);
        skorViewHolder viewHolder = new skorViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull skorViewHolder holder, int position) {
        final int index = holder.getAdapterPosition();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.klubA.setAdapter(arrayAdapter);
        holder.klubB.setAdapter(arrayAdapter);
    }



    @Override
    public int getItemCount() {
        return size;
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }




}
