package com.gastrogo.sortierte_bestellungen_2.Tisch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gastrogo.sortierte_bestellungen_2.R;

public class RV_Adapter_Bestellungen extends RecyclerView.Adapter<RV_Adapter_Bestellungen.ViewHolder> {

    @NonNull
    @Override
    public RV_Adapter_Bestellungen.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row_bestellung, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RV_Adapter_Bestellungen.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView dishName;
        private TextView numberDishes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.dishName = itemView.findViewById(R.id.RV_TV_DishName);
            this.numberDishes = itemView.findViewById(R.id.RV_TV_NumberDishes);
        }

        public TextView getDishName() {
            return dishName;
        }

        public TextView getNumberDishes() {
            return numberDishes;
        }

    }
}
