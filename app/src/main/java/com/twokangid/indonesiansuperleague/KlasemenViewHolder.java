package com.twokangid.indonesiansuperleague;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class KlasemenViewHolder extends RecyclerView.ViewHolder {
    TextView noText, namaText, mainText, menangText, seriText, kalahText, goalText, kebobolanText, poinText;
    View view;

    public KlasemenViewHolder(@NonNull View itemView) {
        super(itemView);
        noText = itemView.findViewById(R.id.nomor_text1);
        namaText = itemView.findViewById(R.id.nama_text1);
        mainText = itemView.findViewById(R.id.main_text1);
        menangText = itemView.findViewById(R.id.menang_text1);
        seriText = itemView.findViewById(R.id.seri_text1);
        kalahText = itemView.findViewById(R.id.kalah_text1);
        goalText = itemView.findViewById(R.id.goal_text1);
        kebobolanText = itemView.findViewById(R.id.kebobolan_text1);
        poinText = itemView.findViewById(R.id.poin_text1);

        view = itemView;
    }
}
