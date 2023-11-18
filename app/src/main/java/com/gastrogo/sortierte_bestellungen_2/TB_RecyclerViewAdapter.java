package com.gastrogo.sortierte_bestellungen_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TB_RecyclerViewAdapter extends RecyclerView.Adapter<TB_RecyclerViewAdapter.MyViewHolder>{

    Context context;
    ArrayList<TischBestellungenModel> tischBestellungenListe;

    public TB_RecyclerViewAdapter(Context context, ArrayList<TischBestellungenModel> tischBestellungenListe){
        //This is where you set up your list
        this.context = context;
        this.tischBestellungenListe = tischBestellungenListe;
    }

    @NonNull
    @Override
    public TB_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This is where you inflate the layout (Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new TB_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TB_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //This is where you bind your data to your rows
        holder.tvTableNumber.setText(String.valueOf(tischBestellungenListe.get(position).getTischNr()));
        holder.tvTimer.setText(String.valueOf(tischBestellungenListe.get(position).getTimer()));

    }

    @Override
    public int getItemCount() {
        //This is where you return the size of your list
        return this.tischBestellungenListe.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTableNumber, tvTimer;
        CheckBox finishedcheckbox;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTableNumber = itemView.findViewById(R.id.tablenumbertext);
            tvTimer = itemView.findViewById(R.id.tabletimertext);
            finishedcheckbox = itemView.findViewById(R.id.finishBestellung);

        }
    }
}
