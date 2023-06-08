package com.twokangid.indonesiansuperleague;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class skorViewHolder extends RecyclerView.ViewHolder {

    Spinner klubA, klubB;
    EditText skorA, skorB;

    View view;

    public skorViewHolder(@NonNull View itemView) {
        super(itemView);

        klubA = itemView.findViewById(R.id.nama_klub_a);
        klubB = itemView.findViewById(R.id.nama_klub_b);
        skorA = itemView.findViewById(R.id.skor_a);
        skorB = itemView.findViewById(R.id.skor_b);

        view = itemView;
    }
}
