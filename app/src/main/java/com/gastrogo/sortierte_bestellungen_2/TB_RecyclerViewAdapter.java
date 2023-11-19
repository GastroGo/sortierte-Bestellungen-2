package com.gastrogo.sortierte_bestellungen_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TB_RecyclerViewAdapter extends RecyclerView.Adapter<TB_RecyclerViewAdapter.MyViewHolder>{

    static Context context;
    ArrayList<TischeBestellungenModel> tischBestellungenListe;

    public TB_RecyclerViewAdapter(Context context, ArrayList<TischeBestellungenModel> tischBestellungenListe){
        this.context = context;
        this.tischBestellungenListe = tischBestellungenListe;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTableNumber.setText("Tisch " + String.valueOf(tischBestellungenListe.get(position).getTischNr()));
        holder.tvTimer.setText(String.valueOf(tischBestellungenListe.get(position).getTimer()));

        // Set click listener for the constraint layout
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cardView.setCardBackgroundColor(1);
                // Handle the click event for the specific item
                // You can perform any action here
                // For example, start a new activity, show a toast, etc.
                //holder.showToast("Clicked on Table: " + (position + 1));
                holder.startNewActivity();
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

        public MyViewHolder(@NonNull View itemView) {
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
