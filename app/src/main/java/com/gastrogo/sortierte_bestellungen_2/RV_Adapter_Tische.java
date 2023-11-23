package com.gastrogo.sortierte_bestellungen_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RV_Adapter_Tische extends RecyclerView.Adapter<RV_Adapter_Tische.ViewHolder>{

    TablelistModel tableListO = TablelistModel.getInstance();
    ArrayList<TableData> tableList = TablelistModel.getTableDataArrayList();

    @NonNull
    @Override
    public RV_Adapter_Tische.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row_tische, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RV_Adapter_Tische.ViewHolder holder, int position) {
        //setting Data
        int pos = position;
        holder.tableNr.setText("Table " + String.valueOf(tableListO.getTableNr(pos)));
        holder.timer.setText(tableListO.getTableTimer(pos));

        if (tableListO.getTableStatus(pos)) {
            holder.checkBox.setChecked(true);
        } else {
            holder.checkBox.setChecked(false);
        }

        //setting Listeners
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableListO.setTableSatus(pos, !tableListO.getTableStatus(pos));
                tableListO.sortTischBestellungenListe();
                notifyDataSetChanged();
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.showToast(view.getContext(), ("Tisch Nr. " + String.valueOf(tableListO.getTableNr(pos))));
            }
        });

    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tableNr;
        private final TextView timer;

        private final CheckBox checkBox;

        private final CardView cardView;

        private ArrayList<TableData> tableList = TablelistModel.getTableDataArrayList();

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tableNr = itemView.findViewById(R.id.RV_TV_TableNr);
            this.timer = itemView.findViewById(R.id.RV_TV_Timer);
            this.checkBox = itemView.findViewById(R.id.RV_CB_CheckBox);
            cardView = itemView.findViewById(R.id.RV_CardView);
        }

        private void showToast(Context context, String message) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }

        public TextView getTableNr() {
            return this.tableNr;
        }

        public TextView getTimer() {
            return this.timer;
        }

        public TextView getCheckBox() {
            return this.checkBox;
        }
    }
}
