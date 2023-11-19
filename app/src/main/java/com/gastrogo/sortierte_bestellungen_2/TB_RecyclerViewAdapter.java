package com.gastrogo.sortierte_bestellungen_2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TB_RecyclerViewAdapter extends RecyclerView.Adapter<TB_RecyclerViewAdapter.MyViewHolder>{

    static Context context;
    ArrayList<TischeBestellungenModel> tischBestellungenListe;

    public TB_RecyclerViewAdapter(Context context){
        this.context = context;
        this.tischBestellungenListe = TischeBestellungenListe.tischBestellungenListe;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvTableNumber.setText("Tisch " + String.valueOf(tischBestellungenListe.get(position).getTischNr()));
        holder.tvTimer.setText(String.valueOf(tischBestellungenListe.get(position).getTimer()));
        if(tischBestellungenListe.get(position).getBestellungAktiv()){
            holder.finishedCheckbox.setChecked(false);
        } else {
            holder.finishedCheckbox.setChecked(true);
        }

        // Set click listener for the constraint layout
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Assuming holder.cardView is your CardView reference
                holder.cardView.setCardBackgroundColor(Color.GREEN);

                // Handle the click event for the specific item
                // You can perform any action here
                // For example, start a new activity, show a toast, etc.
                //holder.showToast("Clicked on Table: " + (holder.getAdapterPosition() + 1));
                holder.startNewActivity();
            }
        });

        holder.finishedCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    if (holder.finishedCheckbox.isChecked()) {
                        holder.finishedCheckbox.setChecked(true);
                        holder.showToast("Bestellung für Tisch " + (adapterPosition + 1) + " wurde abgeschlossen");
                        tischBestellungenListe.get(adapterPosition).setBestellungAktiv(false);
                    } else {
                        holder.finishedCheckbox.setChecked(false);
                        holder.showToast("Bestellung für Tisch " + (adapterPosition + 1) + " wurde wieder aktiviert");
                        tischBestellungenListe.get(adapterPosition).setBestellungAktiv(true);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.tischBestellungenListe.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTableNumber, tvTimer;
        CheckBox finishedCheckbox;
        ConstraintLayout constraintLayout;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            constraintLayout = itemView.findViewById(R.id.constraintlayout);
            tvTableNumber = itemView.findViewById(R.id.tablenumbertext);
            tvTimer = itemView.findViewById(R.id.tabletimertext);
            finishedCheckbox = itemView.findViewById(R.id.finishBestellung);
            cardView = itemView.findViewById(R.id.cardView);
        }

        private void showToast(String message){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }

        private void startNewActivity() {
            Intent intent = new Intent(context, TischBestellungen.class);
            context.startActivity(intent);
        }
    }
}
